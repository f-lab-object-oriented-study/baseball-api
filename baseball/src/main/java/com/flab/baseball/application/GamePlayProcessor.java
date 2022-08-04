package com.flab.baseball.application;

import com.flab.baseball.application.data.GamePlayData;
import com.flab.baseball.domain.GameHistory;
import com.flab.baseball.domain.GameResult;
import com.flab.baseball.domain.Room;
import com.flab.baseball.domain.repository.GameHistoryRepository;
import com.flab.baseball.domain.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamePlayProcessor {

	private final RoomRepository roomRepository;
	private final GameHistoryRepository gameHistoryRepository;

	public GamePlayData execute(Long roomId, String answer) {
		Room room = roomRepository.findRoomById(roomId);
		GameResult gameResult = room.gamePlay(answer);

		gameHistoryRepository.persist(
			GameHistory.create(
				roomId,
				answer,
				gameResult
			)
		);

		return new GamePlayData(room.getRound(), gameResult);
	}

}
