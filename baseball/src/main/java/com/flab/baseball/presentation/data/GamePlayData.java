package com.flab.baseball.presentation.data;

import static com.flab.baseball.util.BaseBallUtils.MAXIMUM_ROUND;

import com.flab.baseball.domain.GameResult;
import lombok.Getter;

@Getter
public class GamePlayData {

	private boolean correct = true;
	private Integer remainingCount;
	private Integer strike;
	private Integer ball;
	private Integer out;

	public GamePlayData(Integer round, GameResult gameResult) {
		this.remainingCount = MAXIMUM_ROUND - round;
		this.strike = gameResult.getStrike();
		this.ball = gameResult.getBall();
		this.out = gameResult.getOut();
	}

}
