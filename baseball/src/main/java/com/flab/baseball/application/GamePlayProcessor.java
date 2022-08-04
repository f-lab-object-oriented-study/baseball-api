package com.flab.baseball.application;

import com.flab.baseball.application.data.GamePlayData;
import com.flab.baseball.domain.GameResult;
import com.flab.baseball.domain.Room;
import com.flab.baseball.infrastructure.RoomRepositoryAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamePlayProcessor {

	private final RoomRepositoryAdaptor roomRepositoryAdaptor;

	public GamePlayData gamePlay(Long roomId, String answer) {
		Room room = roomRepositoryAdaptor.getRoomById(roomId);
		GameResult gameResult = room.gamePlay(answer);

		return new GamePlayData(room.getRound(), gameResult);
	}

}
