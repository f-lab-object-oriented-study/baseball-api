package com.flab.baseball.application.data;

import lombok.Getter;

@Getter
public class GameStartData {

	private Long roomId;

	public GameStartData(Long id) {
		roomId = id;
	}

}
