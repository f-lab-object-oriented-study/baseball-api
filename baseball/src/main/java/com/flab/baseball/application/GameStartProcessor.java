package com.flab.baseball.application;

import com.flab.baseball.application.data.GameStartData;
import com.flab.baseball.domain.Answer;
import com.flab.baseball.domain.RandomAnswerGenerator;
import com.flab.baseball.domain.Room;
import com.flab.baseball.domain.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameStartProcessor {

	private final RoomRepository roomRepository;

	public GameStartData gameStart() {
		Room room = new Room(
			Answer.create(
				new RandomAnswerGenerator()
			)
		);
		Room savedRoom = roomRepository.persist(room);
		return new GameStartData(savedRoom.getId());
	}

}
