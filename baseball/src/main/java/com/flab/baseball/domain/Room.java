package com.flab.baseball.domain;

import static com.flab.baseball.util.BaseBallUtils.MAXIMUM_ROUND;

import com.flab.baseball.domain.answer.Answer;
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

	public AnswerResult gamePlay(String inputAnswer) {
		validGamePlay();

		AnswerResult gameResult = answer.checkAnswer(inputAnswer);
		this.isCorrect = gameResult.isCorrect();
		this.round = this.round + 1;

		return gameResult;
	}

	private void validGamePlay() {
		if (round == MAXIMUM_ROUND || isCorrect) {
			throw new IllegalStateException("이미 종료된 게임입니다.");
		}
	}

	public int getRemainingCount() {
		return MAXIMUM_ROUND - this.round;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
