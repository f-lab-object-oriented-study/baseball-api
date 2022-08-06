package com.flab.baseball.presentation.response.dto;

import com.flab.baseball.application.data.RoomResultQueryData;
import lombok.Getter;

@Getter
public class RoomResultQueryResponse {

	private final Integer remainingCount;
	private final Integer answerCount;

	public RoomResultQueryResponse(RoomResultQueryData roomResultQueryData) {
		this.remainingCount = roomResultQueryData.getRemainingCount();
		this.answerCount = roomResultQueryData.getAnswerCount();
	}

}
