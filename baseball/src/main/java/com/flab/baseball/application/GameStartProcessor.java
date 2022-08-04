package com.flab.baseball.application;

import com.flab.baseball.domain.Room;
import com.flab.baseball.infrastructure.RoomRepositoryAdaptor;
import com.flab.baseball.application.data.GameStartData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameStartProcessor {

	private final RoomRepositoryAdaptor roomRepositoryAdaptor;

	public GameStartData gameStart() {
		Room room = new Room();
		Room savedRoom = roomRepositoryAdaptor.persist(room);
		return new GameStartData(savedRoom.getId());
	}

}
