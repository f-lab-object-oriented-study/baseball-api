package com.flab.baseball.presentation;

import lombok.Getter;

@Getter
public class GameResponse<T> {

	private boolean success = true;
	private T data;
	private GameError error;

	public GameResponse(T data) {
		this.data = data;
	}

}
