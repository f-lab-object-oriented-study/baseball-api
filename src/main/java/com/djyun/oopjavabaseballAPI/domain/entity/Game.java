package com.djyun.oopjavabaseballAPI.domain.entity;

import com.djyun.oopjavabaseballAPI.domain.exception.AlreadyClosedGameException;
import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Game {

	private int roomId;
	private boolean closed;
	private String answer;
	private final int totalCount; // answerCount = totalCount - remainingCount
	private int remainingCount;

	public GuessResult guess(String guessAnswer) {
		if (remainingCount <= 0 || this.closed) {
			throw new AlreadyClosedGameException();
		}
		--this.remainingCount;

		int strike = checkStrike(guessAnswer, this.answer);
		int ball = checkBall(guessAnswer, this.answer);
		int out = this.answer.length() - strike - ball;

		if (this.answer.length() == strike) {
			this.closed = true;
		}

		return new GuessResult(this.closed, this.remainingCount, strike, ball, out);
	}

	private int checkBall(String guessAnswer, String answer) {
		char[] guessAnswerCharArr = guessAnswer.toCharArray();
		char[] answerCharArr = answer.toCharArray();

		int res = 0;
		for (int i = 0; i < answerCharArr.length; i++) {
			if (guessAnswerCharArr[i] != answerCharArr[i] && answer.contains(
				String.valueOf(guessAnswerCharArr[i]))) {
				++res;
			}
		}
		return res;
	}

	private int checkStrike(String guessAnswer, String answer) {
		char[] guessAnswerCharArr = guessAnswer.toCharArray();
		char[] answerCharArr = answer.toCharArray();

		int res = 0;
		for (int i = 0; i < answerCharArr.length; i++) {
            if (guessAnswerCharArr[i] == answerCharArr[i]) {
                ++res;
            }
		}

		return res;
	}

	public GameHistories makeHistory(GuessResult gamePlayResult) {
		return new GameHistories(this.answer, gamePlayResult.getStrike(), gamePlayResult.getBall(),
			gamePlayResult.getOut());
	}
}
