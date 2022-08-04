package com.flab.baseball.application.data;

import com.flab.baseball.domain.GameHistory;
import lombok.Getter;

@Getter
public class GameHistoryResultData {

	private final int strike;
	private final int ball;
	private final int out;

	public GameHistoryResultData(GameHistory gameHistory) {
		this.strike = gameHistory.getStrike();
		this.ball = gameHistory.getBall();
		this.out = gameHistory.getOut();
	}

}
