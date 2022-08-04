package com.flab.baseball.infrastructure;

import com.flab.baseball.domain.GameHistory;

public interface GameHistoryRepository {

	GameHistory persist(GameHistory gameHistory);

}
