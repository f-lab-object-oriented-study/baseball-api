package com.flab.baseball.infrastructure;

import com.flab.baseball.domain.GameHistory;
import com.flab.baseball.domain.repository.GameHistoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameHistoryRepositoryAdaptor implements GameHistoryRepository {

	private final MemoryGameHistoryRepository gameHistoryRepository;

	public GameHistory persist(GameHistory gameHistory) {
		return gameHistoryRepository.persist(gameHistory);
	}

	public List<GameHistory> findAllByRoomId(Long roomId) {
		return gameHistoryRepository.findAllByRoomId(roomId);
	}

}
