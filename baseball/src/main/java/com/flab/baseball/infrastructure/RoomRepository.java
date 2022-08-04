package com.flab.baseball.infrastructure;

import com.flab.baseball.domain.Room;

public interface RoomRepository {

	Room persist(Room room);

	Room getRoomById(Long id);

}
