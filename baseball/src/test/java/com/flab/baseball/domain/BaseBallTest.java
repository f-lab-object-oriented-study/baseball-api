package com.flab.baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseBallTest {

	@Test
	void 쓰리스트라이크() {
		// given
		BaseBallGame baseBall = new BaseBallGame("123");

		// when
		GameResult gameResult = baseBall.play("123");

		// then
		assertThat(gameResult).isEqualTo(new GameResult(3, 0, 0));
	}

	@Test
	void 투스트라이크원아웃() {
		// given
		BaseBallGame baseBall = new BaseBallGame("123");

		// when
		GameResult gameResult = baseBall.play("143");

		// then
		assertThat(gameResult).isEqualTo(new GameResult(2, 0, 1));
	}

	@Test
	void 쓰리볼() {
		// given
		BaseBallGame baseBall = new BaseBallGame("123");

		// when
		GameResult gameResult = baseBall.play("231");

		// then
		assertThat(gameResult).isEqualTo(new GameResult(0, 3, 0));
	}

	@Test
	void 쓰리아웃() {
		// given
		BaseBallGame baseBall = new BaseBallGame("123");

		// when
		GameResult gameResult = baseBall.play("456");

		// then
		assertThat(gameResult).isEqualTo(new GameResult(0, 0, 3));
	}

}
