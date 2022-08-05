package com.djyun.oopjavabaseballAPI.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuessResult {

	private boolean correct;
	private int remainingCount;
	private int strike;
	private int ball;
	private int out;
}
