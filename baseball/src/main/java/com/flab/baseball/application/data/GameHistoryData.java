package com.flab.baseball.application.data;

import com.flab.baseball.domain.GameHistory;
import lombok.Getter;

@Getter
public class GameHistoryData {

	private final String answer;
	private final GameHistoryResultData result;

	public GameHistoryData(GameHistory gameHistory) {
		this.answer = gameHistory.getAnswer();
		this.result = new GameHistoryResultData(gameHistory);
	}

}
