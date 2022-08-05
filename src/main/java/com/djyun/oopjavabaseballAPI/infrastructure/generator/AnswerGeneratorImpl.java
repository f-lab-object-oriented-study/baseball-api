package com.djyun.oopjavabaseballAPI.infrastructure.generator;

import com.djyun.oopjavabaseballAPI.domain.generator.AnswerGenerator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AnswerGeneratorImpl implements AnswerGenerator {

	int letter = 3;
	String answer = "";

	@Override
	public String generate() {
		Random random = new Random();
		while (answer.length() < 3) {
			int randomInt = random.nextInt(9) + 1;
			if (answer.contains(String.valueOf(randomInt))) {
				continue;
			}
			answer += String.valueOf(randomInt);
		}
		return answer;
	}
}
