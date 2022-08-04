package com.djyun.oopjavabaseballAPI.infrastructure.memory;

import com.djyun.oopjavabaseballAPI.domain.entity.Game;
import com.djyun.oopjavabaseballAPI.domain.entity.GameHistories;
import com.djyun.oopjavabaseballAPI.domain.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GameRepositoryAdapter implements GameRepository {
    private final InmemoryRepository inmemoryRepository;

    @Override
    public Game save(Game game) {
        return this.inmemoryRepository.save(game);
    }

    @Override
    public Game findById(int roomId) {
        return this.inmemoryRepository.findById(roomId);
    }

    @Override
    public void saveHistory(int roomId, GameHistories gameHistories) {
        this.inmemoryRepository.saveHistory(roomId, gameHistories);
    }

    @Override
    public GameHistories getHistories(int roomId) {
        return this.inmemoryRepository.getHistories(roomId);
    }
}
