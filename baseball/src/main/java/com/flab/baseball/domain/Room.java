package com.flab.baseball.domain;

import static com.flab.baseball.util.BaseBallUtils.MAXIMUM_ROUND;

import lombok.Getter;

@Getter
public class Room {

	private Long id;
	private int round;
	private boolean isCorrect;
	private final Answer answer;

	public Room(Answer answer) {
		this(0, answer);
	}

	private Room(int round, Answer answer) {
		this.round = round;
		this.answer = answer;
	}

	public GameResult gamePlay(String inputAnswer) {
		nextRound();
		GameResult gameResult = answer.game(inputAnswer);
		this.isCorrect = gameResult.isCorrect();


		return gameResult;
	}

	private int nextRound() {
		if (round == MAXIMUM_ROUND || isCorrect) {
			throw new IllegalStateException("이미 종료된 게임입니다.");
		}

		return ++round;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
