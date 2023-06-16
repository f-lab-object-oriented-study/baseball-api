package com.flab.baseball.infrastructure;

import com.flab.baseball.domain.GameHistory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryGameHistoryRepository {

	Map<Long, GameHistory> histories = new ConcurrentHashMap<>();

	public GameHistory persist(GameHistory gameHistory) {
		if (gameHistory.getId() == null) {
			gameHistory.setId((long) histories.size());
		}

		GameHistory savedHistory = histories.putIfAbsent(gameHistory.getId(), gameHistory);
		if (savedHistory != null) {
			throw new IllegalArgumentException("이미 존재하는 룸 번호 입니다.");
		}

		return histories.get(gameHistory.getId());
	}

	public List<GameHistory> findAllByRoomId(Long roomId) {
		List<GameHistory> gameHistories = new ArrayList<>();

		for (Entry<Long, GameHistory> entry : histories.entrySet()) {
			GameHistory value = entry.getValue();

			if (roomId.equals(value.getRoomId())) {
				gameHistories.add(value);
			}
		}

		return gameHistories;
	}

}
