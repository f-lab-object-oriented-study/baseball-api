package com.djyun.oopjavabaseballAPI.domain.repository;

import com.djyun.oopjavabaseballAPI.domain.entity.Game;
import com.djyun.oopjavabaseballAPI.domain.entity.GameHistories;


public interface GameRepository {

	Game save(Game game);

	Game findById(int roomId);

	void saveHistory(int roomId, GameHistories gameHistories);

	GameHistories getHistories(int roomId);
}
