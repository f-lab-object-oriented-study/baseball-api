package com.flab.baseball.application.data;

import static com.flab.baseball.util.BaseBallUtils.MAXIMUM_ROUND;

import lombok.Getter;

@Getter
public class RoomResultData {

	private Integer remainingCount;
	private Integer answerCount;

	public RoomResultData(Integer round) {
		this.remainingCount = MAXIMUM_ROUND - round;
		this.answerCount = round;
	}
}