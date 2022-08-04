package com.flab.baseball.infrastructure;

import com.flab.baseball.domain.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomRepositoryAdaptor {

	private final RoomRepository roomRepository;

	public Room persist(Room room) {
		return roomRepository.persist(room);
	}

	public Room getRoomById(Long id) {
		return roomRepository.getRoomById(id);
	}

}
