package com.flab.baseball.application;

import com.flab.baseball.application.data.RoomResultData;
import com.flab.baseball.domain.Room;
import com.flab.baseball.domain.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomResultProcessor {

	private final RoomRepository roomRepository;

	public RoomResultData execute(Long roomId) {
		Room room = roomRepository.findRoomById(roomId);
		return new RoomResultData(room.getRound());
	}

}
