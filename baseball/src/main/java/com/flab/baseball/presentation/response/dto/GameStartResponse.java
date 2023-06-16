package com.flab.baseball.presentation.response.dto;

import com.flab.baseball.application.data.GameStartData;
import lombok.Getter;

@Getter
public class GameStartResponse {

	private final Long roomId;

	public GameStartResponse(GameStartData data) {
		roomId = data.getRoomId();
	}

}
