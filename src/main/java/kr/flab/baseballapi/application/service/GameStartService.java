package kr.flab.baseballapi.application.service;

import org.springframework.stereotype.Service;

import kr.flab.baseballapi.domain.baseball.Game;
import kr.flab.baseballapi.infrastructure.persistence.entity.GameRoomEntity;
import kr.flab.baseballapi.infrastructure.persistence.repository.GameRoomRepository;
import kr.flab.baseballapi.presentation.data.GameStartData;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GameStartService {

    private final GameRoomRepository gameRoomRepository;
    private final Long REMAINING_COUNT = 10L;

    public GameStartData progress() {
        GameRoomEntity gameRoom = new GameRoomEntity(REMAINING_COUNT, new Game().exportAnswer(), false);
        GameRoomEntity savedGameRoom = gameRoomRepository.save(gameRoom);

        return new GameStartData(savedGameRoom.getRoomId());
    }
    
}
