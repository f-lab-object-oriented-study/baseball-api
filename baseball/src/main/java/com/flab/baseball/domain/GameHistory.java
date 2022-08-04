package com.flab.baseball.domain;

import lombok.Getter;

@Getter
public class GameHistory {

	private Long id;
	private Long roomId;
	private String answer;
	private int strike;
	private int ball;
	private int out;

	public static GameHistory create(Long roomId, String answer, GameResult gameResult) {
		return new GameHistory(roomId, answer, gameResult.getStrike(), gameResult.getBall(), gameResult.getOut());
	}

	public GameHistory(Long roomId, String answer, int strike, int ball, int out) {
		this.roomId = roomId;
		this.answer = answer;
		this.strike = strike;
		this.ball = ball;
		this.out = out;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean hasRoomId(Long roomId) {
		return this.roomId.equals(roomId);
	}
}
