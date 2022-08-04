package com.flab.baseball.infrastructure;

import com.flab.baseball.domain.GameHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameHistoryRepositoryAdaptor {

	private final GameHistoryRepository gameHistoryRepository;

	public GameHistory persist(GameHistory gameHistory) {
		return gameHistoryRepository.persist(gameHistory);
	}

}
