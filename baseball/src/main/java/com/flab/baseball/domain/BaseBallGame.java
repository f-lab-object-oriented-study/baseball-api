package com.flab.baseball.domain;

public class BaseBallGame {

	private String answer;

	public BaseBallGame(String answer) {
		this.answer = answer;
	}

	public GameResult play(String number) {
		String[] answers = answer.split("");
		String[] numbers = number.split("");
		int strike = 0;
		int ball = 0;
		int out = 0;

		for (int i = 0; i < numbers.length; i++) {
			String num = numbers[i];
			if (num.equals(answers[i])) {
				strike++;
			} else if (answer.contains(num)) {
				ball++;
			} else {
				out++;
			}
		}

		return new GameResult(strike, ball, out);
	}

}
