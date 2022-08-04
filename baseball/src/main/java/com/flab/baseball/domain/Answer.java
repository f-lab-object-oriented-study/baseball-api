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

}
