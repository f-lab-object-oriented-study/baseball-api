package kr.flab.baseballapi.application.service;

import org.springframework.stereotype.Service;

import kr.flab.baseballapi.infrastructure.persistence.entity.GameRoomEntity;
import kr.flab.baseballapi.infrastructure.persistence.repository.GameRoomRepository;
import kr.flab.baseballapi.presentation.data.GameResultData;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GameResultService {

    private final GameRoomRepository gameRoomRepository;

    public GameResultData progress(Long roomId) {
        GameRoomEntity gameRoom = gameRoomRepository.findById(roomId).get();
        return new GameResultData(gameRoom.getRemainingCount(), gameRoom.getAnswerCount());
    }
    
}
