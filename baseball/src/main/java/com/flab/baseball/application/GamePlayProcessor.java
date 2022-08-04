package com.flab.baseball.application;

import com.flab.baseball.domain.BaseBallGame;
import com.flab.baseball.domain.GameResult;
import com.flab.baseball.domain.Room;
import com.flab.baseball.infrastructure.RoomRepositoryAdaptor;
import com.flab.baseball.application.data.GamePlayData;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamePlayProcessor {

	private final RoomRepositoryAdaptor roomRepositoryAdaptor;

	private static final SecureRandom RANDOM = new SecureRandom();
	private static final int NUMBER_BOUND = 10;
	private static final int NUMBER_SIZE = 3;
	private static final int MINIMUM_NUMBER = 1;

	public GamePlayData gamePlay(Long roomId, String answer) {
		Room room = roomRepositoryAdaptor.getRoomById(roomId);
		Integer round = room.nextRound();

		BaseBallGame baseBall = new BaseBallGame(answer);
		GameResult gameResult = baseBall.play(generatePlayNumber());

		return new GamePlayData(round, gameResult);
	}

	private String generatePlayNumber() {
		Set<Integer> numbers = new HashSet<>();

		while (numbers.size() < NUMBER_SIZE) {
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
