package com.flab.baseball.presentation.data;

import lombok.Getter;

@Getter
public class GameStartData {

	private Long roomId;

	public GameStartData(Long id) {
		roomId = id;
	}

}
