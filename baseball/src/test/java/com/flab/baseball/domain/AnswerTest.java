package com.flab.baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.flab.baseball.domain.answer.Answer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AnswerTest {

	@Test
	void 생성성공() {
		// given
		Answer answer = Answer.create(() -> "123");

		// when
		// then
		assertThat(answer).isInstanceOf(Answer.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"12", "3423", "12355"})
	void 생성실패_길이가3이아닐경우(String answer) {
		// given
		// when
		// then
		assertThatThrownBy(() -> Answer.create(() -> answer))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 쓰리스트라이크() {
		// given
		Answer answer = Answer.create(() -> "123");

		// when
		AnswerResult gameResult = answer.checkAnswer("123");

		// then
		assertThat(gameResult).isEqualTo(new AnswerResult(3, 0, 0));
	}

	@Test
	void 투스트라이크원아웃() {
		// given
		Answer answer = Answer.create(() -> "123");

		// when
		AnswerResult gameResult = answer.checkAnswer("143");

		// then
		assertThat(gameResult).isEqualTo(new AnswerResult(2, 0, 1));
	}

	@Test
	void 쓰리볼() {
		// given
		Answer answer = Answer.create(() -> "123");

		// when
		AnswerResult gameResult = answer.checkAnswer("231");

		// then
		assertThat(gameResult).isEqualTo(new AnswerResult(0, 3, 0));
	}

	@Test
	void 쓰리아웃() {
		// given
		Answer answer = Answer.create(() -> "123");

		// when
		AnswerResult gameResult = answer.checkAnswer("456");

		// then
		assertThat(gameResult).isEqualTo(new AnswerResult(0, 0, 3));
	}

}
