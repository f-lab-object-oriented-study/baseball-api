package com.flab.baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RoomTest {

	@Test
	void 게임카운트() {
		// given
		Room room = new Room(Answer.create(new RandomAnswerGenerator()));

		// when
		Integer nextRound = room.nextRound();

		// then
		assertThat(nextRound).isEqualTo(1);
	}

	@Test
	void 게임횟수초과() {
		// given
		Room room = new Room(Answer.create(new RandomAnswerGenerator()));

		// when
		room.nextRound();
		room.nextRound();
		room.nextRound();
		room.nextRound();
		room.nextRound();
		room.nextRound();
		room.nextRound();
		room.nextRound();
		room.nextRound();
		room.nextRound();

		// then
		assertThatThrownBy(room::nextRound)
			.isInstanceOf(IllegalStateException.class);
	}

}
