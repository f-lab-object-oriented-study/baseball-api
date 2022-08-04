package com.flab.baseball.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class GameResult {

	private int strike;
	private int ball;
	private int out;

	public GameResult(int strike, int ball, int out) {
		this.strike = strike;
		this.ball = ball;
		this.out = out;
	}

}
