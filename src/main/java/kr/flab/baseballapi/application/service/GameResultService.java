package kr.flab.baseballapi.application.service;

import org.springframework.stereotype.Service;

import kr.flab.baseballapi.application.data.GameResultData;
import kr.flab.baseballapi.infrastructure.persistence.entity.GameRoom;
import kr.flab.baseballapi.infrastructure.persistence.repository.GameRoomRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GameResultService {

    private final GameRoomRepository gameRoomRepository;

    public GameResultData progress(Long roomId) {
        GameRoom gameRoom = gameRoomRepository.findById(roomId).get();
        return new GameResultData(gameRoom.getRemainingCount(), gameRoom.getAnswerCount());
    }
    
}
