package com.djyun.oopjavabaseballAPI.presentation.response;

import com.djyun.oopjavabaseballAPI.domain.entity.GuessResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GamePlayResponse {

	private boolean correct;
	private int remainingCount;
	private int strike;
	private int ball;
	private int out;

	public static GamePlayResponse from(GuessResult guessResult) {
		return new GamePlayResponse(
			guessResult.isCorrect(),
			guessResult.getRemainingCount(),
			guessResult.getStrike(),
			guessResult.getBall(),
			guessResult.getOut()
		);
	}

}
