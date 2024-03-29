package com.flab.baseball.infrastructure;

import com.flab.baseball.domain.Room;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryRoomRepository {

	Map<Long, Room> rooms = new ConcurrentHashMap<>();

	public Room persist(Room room) {
		if (room.getId() == null) {
			room.setId((long) rooms.size());
		}

		Room savedRoom = rooms.putIfAbsent(room.getId(), room);
		if (savedRoom != null) {
			throw new IllegalArgumentException("이미 존재하는 룸 번호 입니다.");
		}

		return rooms.get(room.getId());
	}

	public Optional<Room> findRoomById(Long id) {
		return Optional.ofNullable(rooms.get(id));
	}

}
