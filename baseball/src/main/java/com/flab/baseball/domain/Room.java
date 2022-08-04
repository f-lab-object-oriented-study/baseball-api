package com.flab.baseball.domain;

import static com.flab.baseball.util.BaseBallUtils.MAXIMUM_ROUND;

import lombok.Getter;

@Getter
public class Room {

	private Long id;
	private Integer round;

	public Room() {
		this.round = 0;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer nextRound() {
		if (round == MAXIMUM_ROUND) {
			throw new IllegalStateException("이미 종료된 게임입니다.");
		}

		return ++round;
	}

}
