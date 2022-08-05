package com.djyun.oopjavabaseballAPI.infrastructure.generator;

import com.djyun.oopjavabaseballAPI.domain.generator.GameIdGenerator;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class GameIdGeneratorImpl implements GameIdGenerator {

	private AtomicInteger atomicInteger = new AtomicInteger(100);

	@Override
	public int generate() {
		return atomicInteger.incrementAndGet();
	}
}
