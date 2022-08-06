package com.flab.baseball.presentation.response;

import lombok.Getter;

@Getter
public class GameResponse<T> {

	private boolean success = true;
	private T data;
	private GameError error;

	public GameResponse(T data) {
		this(data, null);
	}

	private GameResponse(T data, GameError gameError) {
		this.data = data;
		this.error = gameError;
	}

	public static GameResponse<Object> toError(ErrorCode errorCode) {
		return new GameResponse<>(null, new GameError(errorCode));
	}
}
