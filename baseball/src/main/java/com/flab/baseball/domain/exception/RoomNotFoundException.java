package com.flab.baseball.domain.exception;

public class RoomNotFoundException extends RuntimeException {

	private static final String MESSAGE = "존재하지 않는 룸 번호 입니다.";

	public RoomNotFoundException() {
		super(MESSAGE);
	}

}
