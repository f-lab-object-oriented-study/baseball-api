package com.flab.baseball.domain.repository;

import com.flab.baseball.domain.Room;

public interface RoomRepository {

	Room persist(Room room);

	Room findRoomById(Long id);

}
