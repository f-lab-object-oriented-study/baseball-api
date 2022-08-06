package com.flab.baseball.presentation.response;

import lombok.Getter;

@Getter
public class GameError {

	private ErrorCode code;
	private String message;

	public GameError(ErrorCode errorCode) {
		this.code = errorCode;
	}

}
