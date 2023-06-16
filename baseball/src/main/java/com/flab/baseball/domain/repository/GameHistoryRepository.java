package com.flab.baseball.domain.repository;

import com.flab.baseball.domain.GameHistory;
import java.util.List;

public interface GameHistoryRepository {

	GameHistory persist(GameHistory gameHistory);

	List<GameHistory> findAllByRoomId(Long roomId);

}
