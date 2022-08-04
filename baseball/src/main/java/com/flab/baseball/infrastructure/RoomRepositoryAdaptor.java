package com.flab.baseball.infrastructure;

import com.flab.baseball.domain.Room;
import com.flab.baseball.domain.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomRepositoryAdaptor implements RoomRepository {

	private final MemoryRoomRepository roomRepository;

	@Override
	public Room persist(Room room) {
		return roomRepository.persist(room);
	}

	@Override
	public Room findRoomById(Long id) {
		return roomRepository.findRoomById(id);
	}

}
