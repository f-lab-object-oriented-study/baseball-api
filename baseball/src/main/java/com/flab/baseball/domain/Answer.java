package com.flab.baseball.domain;

import static com.flab.baseball.util.BaseBallUtils.ANSWER_LENGTH;

import lombok.Getter;

@Getter
public class Answer {

	private final String answerNumber;

	public static Answer create(AnswerGenerator generator) {
		return new Answer(generator.generate());
	}

	private Answer(String answer) {
		if (answer.length() != ANSWER_LENGTH) {
			throw new IllegalArgumentException("올바르지 않은 정답입니다.");
		}

		this.answerNumber = answer;
	}

	public GameResult play(String inputAnswer) {
		String[] answers = answerNumber.split("");
		String[] inputAnswers = inputAnswer.split("");
		int strike = 0;
		int ball = 0;
		int out = 0;

		for (int idx = 0; idx < inputAnswers.length; idx++) {
			String num = inputAnswers[idx];
			if (num.equals(answers[idx])) {
				strike++;
			} else if (answerNumber.contains(num)) {
				ball++;
			} else {
				out++;
			}
		}

		return new GameResult(strike, ball, out);
	}

}
