package com.flab.baseball.application.data;

import com.flab.baseball.domain.Room;
import lombok.Getter;

@Getter
public class RoomResultQueryData {

	private final Integer remainingCount;
	private final Integer answerCount;

	public RoomResultQueryData(Room room) {
		this.remainingCount = room.getRemainingCount();
		this.answerCount = room.getRound();
	}

}
