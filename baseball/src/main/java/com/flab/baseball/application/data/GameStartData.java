package com.flab.baseball.application.data;

import lombok.Getter;

@Getter
public class GameStartData {

	private final Long roomId;

	public GameStartData(Long id) {
		roomId = id;
	}

}
