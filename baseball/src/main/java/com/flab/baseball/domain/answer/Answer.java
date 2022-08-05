package com.flab.baseball.domain.answer;

import static com.flab.baseball.util.BaseBallUtils.ANSWER_LENGTH;

import com.flab.baseball.domain.GameResult;
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

	public GameResult gamePlay(String inputAnswer) {
		String[] answers = answerNumber.split("");
		String[] inputAnswers = inputAnswer.split("");
		int strike = 0;
		int ball = 0;
		int out = 0;

		for (int idx = 0; idx < inputAnswers.length; idx++) {
			String num = inputAnswers[idx];
			if (isStrike(answers[idx], num)) {
				strike++;
			} else if (isBall(num)) {
				ball++;
			} else {
				out++;
			}
		}

		return new GameResult(strike, ball, out);
	}

	private boolean isStrike(String answer, String inputNumber) {
		return answer.equals(inputNumber);
	}

	private boolean isBall(String inputNumber) {
		return answerNumber.contains(inputNumber);
	}

}
