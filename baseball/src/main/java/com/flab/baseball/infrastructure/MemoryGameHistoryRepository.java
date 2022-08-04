package com.flab.baseball.infrastructure;

import com.flab.baseball.domain.GameHistory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryGameHistoryRepository implements GameHistoryRepository {

	Map<Long, GameHistory> histories = new ConcurrentHashMap<>();

	@Override
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

}
