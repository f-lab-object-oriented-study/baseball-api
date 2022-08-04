package com.flab.baseball.application;

import com.flab.baseball.application.data.GameHistoriesData;
import com.flab.baseball.domain.GameHistory;
import com.flab.baseball.domain.repository.GameHistoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameHistoriesSearchProcessor {

	private final GameHistoryRepository gameHistoryRepository;

	public GameHistoriesData findHistories(Long roomId) {
		List<GameHistory> gameHistories = gameHistoryRepository.findAllByRoomId(roomId);
		return new GameHistoriesData(gameHistories);
	}

}
