package com.flab.baseball.domain.repository;

import com.flab.baseball.domain.Room;
import java.util.Optional;

public interface RoomRepository {

	Room persist(Room room);

	Optional<Room> findRoomById(Long id);

}
