package com.flab.baseball.application.data;

import static com.flab.baseball.util.BaseBallUtils.MAXIMUM_ROUND;

import com.flab.baseball.domain.GameResult;
import lombok.Getter;

@Getter
public class GamePlayData {

	private final boolean correct;
	private final int remainingCount;
	private final int strike;
	private final int ball;
	private final int out;

	public GamePlayData(int round, GameResult gameResult) {
		this.correct = gameResult.isCorrect();
		this.remainingCount = MAXIMUM_ROUND - round;
		this.strike = gameResult.getStrike();
		this.ball = gameResult.getBall();
		this.out = gameResult.getOut();
	}

}
