package com.flab.baseball.application;

import com.flab.baseball.application.data.GamePlayData;
import com.flab.baseball.domain.GameHistory;
import com.flab.baseball.domain.GameResult;
import com.flab.baseball.domain.Room;
import com.flab.baseball.infrastructure.GameHistoryRepositoryAdaptor;
import com.flab.baseball.infrastructure.RoomRepositoryAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamePlayProcessor {

	private final RoomRepositoryAdaptor roomRepositoryAdaptor;
	private final GameHistoryRepositoryAdaptor gameHistoryRepositoryAdaptor;

	public GamePlayData gamePlay(Long roomId, String answer) {
		Room room = roomRepositoryAdaptor.getRoomById(roomId);
		GameResult gameResult = room.gamePlay(answer);

		gameHistoryRepositoryAdaptor.persist(
			GameHistory.create(
				roomId,
				answer,
				gameResult
			)
		);

		return new GamePlayData(room.getRound(), gameResult);
	}

}
