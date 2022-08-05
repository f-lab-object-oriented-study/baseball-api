package com.djyun.oopjavabaseballAPI.presentation.handler;

import com.djyun.oopjavabaseballAPI.domain.exception.AlreadyClosedGameException;
import com.djyun.oopjavabaseballAPI.domain.exception.HasNoIdException;
import com.djyun.oopjavabaseballAPI.shared.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GameExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(HasNoIdException.class)
	public ApiResponse<Object> handle(HasNoIdException e) {
		return ApiResponse.fail("NOT_FOUND_GAME", "game is not found");
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AlreadyClosedGameException.class)
	public ApiResponse<Object> handle(AlreadyClosedGameException e) {
		return ApiResponse.fail("CLOSED_GAME", "game is already closed");
	}
}
