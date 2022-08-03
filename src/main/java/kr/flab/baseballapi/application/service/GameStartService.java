package kr.flab.baseballapi.application.service;

import org.springframework.stereotype.Service;

import kr.flab.baseballapi.application.data.GameStartData;
import kr.flab.baseballapi.domain.baseball.Game;
import kr.flab.baseballapi.infrastructure.persistence.entity.GameRoom;
import kr.flab.baseballapi.infrastructure.persistence.repository.GameRoomRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GameStartService {

    private final GameRoomRepository gameRoomRepository;

    public GameStartData progress() {
        GameRoom gameRoom = new GameRoom(10L, new Game().exportAnswer());
        GameRoom savedGameRoom = gameRoomRepository.save(gameRoom);

        return new GameStartData(savedGameRoom.getRoomId());
    }
    
}
