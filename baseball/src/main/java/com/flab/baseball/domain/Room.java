package com.flab.baseball.domain;

import static com.flab.baseball.util.BaseBallUtils.MAXIMUM_ROUND;

import lombok.Getter;

@Getter
public class Room {

	private Long id;
	private Integer round;
	private final Answer answer;

	public Room(Answer answer) {
		this(0, answer);
	}

	private Room(Integer round, Answer answer) {
		this.round = round;
		this.answer = answer;
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
