package com.flab.baseball.presentation.response.dto;

import com.flab.baseball.application.data.GamePlayData;
import lombok.Getter;

@Getter
public class GamePlayResponse {

	private final boolean correct;
	private final int remainingCount;
	private final int strike;
	private final int ball;
	private final int out;

	public GamePlayResponse(GamePlayData gamePlayData) {
		this.correct = gamePlayData.isCorrect();
		this.remainingCount = gamePlayData.getRemainingCount();
		this.strike = gamePlayData.getStrike();
		this.ball = gamePlayData.getBall();
		this.out = gamePlayData.getOut();
	}

}
