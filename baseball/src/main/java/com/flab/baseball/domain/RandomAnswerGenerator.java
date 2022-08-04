package com.flab.baseball.domain;

import static com.flab.baseball.util.BaseBallUtils.ANSWER_LENGTH;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomAnswerGenerator implements AnswerGenerator {

	private static final SecureRandom RANDOM = new SecureRandom();

	private static final int NUMBER_BOUND = 10;
	private static final int MINIMUM_NUMBER = 1;

	@Override
	public String generate() {
		Set<Integer> numbers = new HashSet<>();

		while (numbers.size() < ANSWER_LENGTH) {
			int number = RANDOM.nextInt(NUMBER_BOUND);

			if (number >= MINIMUM_NUMBER) {
				numbers.add(number);
			}
		}

		return numbers.stream()
			.map(String::valueOf)
			.collect(Collectors.joining());
	}

}
