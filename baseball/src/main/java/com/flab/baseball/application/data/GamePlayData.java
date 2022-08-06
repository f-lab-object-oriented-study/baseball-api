package com.flab.baseball.application.data;

import com.flab.baseball.domain.AnswerResult;
import com.flab.baseball.domain.Room;
import lombok.Getter;

@Getter
public class GamePlayData {

	private final boolean correct;
	private final int remainingCount;
	private final int strike;
	private final int ball;
	private final int out;

	public GamePlayData(Room room, AnswerResult gameResult) {
		this.correct = gameResult.isCorrect();
		this.remainingCount = room.getRemainingCount();
		this.strike = gameResult.getStrike();
		this.ball = gameResult.getBall();
		this.out = gameResult.getOut();
	}

}
