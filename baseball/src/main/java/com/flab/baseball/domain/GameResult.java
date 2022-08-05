package com.flab.baseball.domain;

import static com.flab.baseball.util.BaseBallUtils.ANSWER_LENGTH;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class GameResult {

	private final int strike;
	private final int ball;
	private final int out;

	public GameResult(int strike, int ball, int out) {
		this.strike = strike;
		this.ball = ball;
		this.out = out;
	}

	public boolean isCorrect() {
		return strike == ANSWER_LENGTH;
	}

}
