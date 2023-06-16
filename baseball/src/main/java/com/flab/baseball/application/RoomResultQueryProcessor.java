package com.flab.baseball.application;

import com.flab.baseball.application.data.RoomResultQueryData;
import com.flab.baseball.domain.Room;
import com.flab.baseball.domain.exception.RoomNotFoundException;
import com.flab.baseball.domain.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomResultQueryProcessor {

	private final RoomRepository roomRepository;

	public RoomResultQueryData execute(Long roomId) {
		Room room = roomRepository.findRoomById(roomId)
			.orElseThrow(RoomNotFoundException::new);

		return new RoomResultQueryData(room);
	}

}
