package com.flab.baseball.domain;

import lombok.Getter;

@Getter
public class GameHistory {

	private Long id;
	private final Long roomId;
	private final String answer;
	private final int strike;
	private final int ball;
	private final int out;

	public static GameHistory create(Long roomId, String answer, AnswerResult gameResult) {
		return new GameHistory(roomId, answer, gameResult.getStrike(), gameResult.getBall(), gameResult.getOut());
	}

	private GameHistory(Long roomId, String answer, int strike, int ball, int out) {
		this.roomId = roomId;
		this.answer = answer;
		this.strike = strike;
		this.ball = ball;
		this.out = out;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
