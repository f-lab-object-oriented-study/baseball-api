package com.djyun.oopjavabaseballAPI.infrastructure.memory;

import com.djyun.oopjavabaseballAPI.domain.entity.Game;
import com.djyun.oopjavabaseballAPI.domain.entity.GameHistories;
import com.djyun.oopjavabaseballAPI.domain.entity.GuessResult;
import com.djyun.oopjavabaseballAPI.domain.exception.HasNoIdException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class InmemoryRepository {
    private static final Map<Integer, Game> gameMemoryMap = new ConcurrentHashMap<>();
    private static final Map<Integer, List<GameHistories>> gameHistoryMap = new ConcurrentHashMap<>();
    public Game save(Game game) {
        gameMemoryMap.put(game.getRoomId(), game);
        return game;
    }

    public Game findById(int roomId) {
        if (gameMemoryMap.containsKey(roomId)){
            return gameMemoryMap.get(roomId);
        }
        throw new HasNoIdException();
    }

    public void saveHistory(int roomId, GameHistories gameHistories) {
        List<GameHistories> gameHistoriesList = gameHistoryMap.getOrDefault(roomId, new ArrayList<GameHistories>());
        gameHistoriesList.add(gameHistories);
        gameHistoryMap.put(roomId,gameHistoriesList);
    }

    public GameHistories getHistories(int roomId) {
        if (gameHistoryMap.containsKey(roomId)){
            return new GameHistories(gameHistoryMap.get(roomId));
        }
        throw new HasNoIdException();
    }

}
