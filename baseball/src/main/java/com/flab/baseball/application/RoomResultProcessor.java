package com.flab.baseball.application;

import com.flab.baseball.domain.Room;
import com.flab.baseball.infrastructure.RoomRepositoryAdaptor;
import com.flab.baseball.application.data.RoomResultData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomResultProcessor {

	private final RoomRepositoryAdaptor roomRepositoryAdaptor;

	public RoomResultData roomResult(Long roomId) {
		Room room = roomRepositoryAdaptor.getRoomById(roomId);
		return new RoomResultData(room.getRound());
	}

}
