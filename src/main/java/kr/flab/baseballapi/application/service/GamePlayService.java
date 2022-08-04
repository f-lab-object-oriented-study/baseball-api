package kr.flab.baseballapi.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.flab.baseballapi.domain.baseball.GameRoom;
import kr.flab.baseballapi.domain.baseball.JudgeResult;
import kr.flab.baseballapi.infrastructure.persistence.entity.GameHistoryEntity;
import kr.flab.baseballapi.infrastructure.persistence.entity.GameRoomEntity;
import kr.flab.baseballapi.infrastructure.persistence.repository.GameHistoryRepository;
import kr.flab.baseballapi.infrastructure.persistence.repository.GameRoomRepository;
import kr.flab.baseballapi.presentation.data.GamePlayData;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GamePlayService {

    private final GameRoomRepository gameRoomRepository;
    private final GameHistoryRepository gameHistoryRepository;

    public Optional<GamePlayData> progress(Long roomId, String answer) {
        Optional<GameRoomEntity> optGameRoomEntity = gameRoomRepository.findById(roomId);
        if (!isValidGameRoom(optGameRoomEntity)) {
            return Optional.empty();
        }

        GameRoomEntity gameRoomEntity = optGameRoomEntity.get();
        
        GameRoom gameRoom = GameRoom.fromEntity(gameRoomEntity);
        JudgeResult judgeResult = gameRoom.judge(answer);

        gameRoomEntity.updateCounts(gameRoom.getRemainingCount(), gameRoom.getAnswerCount());
        if (gameRoom.isClosed()) {
            gameRoomEntity.updateClosed();
        }
        gameRoomRepository.save(gameRoomEntity);

        log(roomId, answer, judgeResult);

        GamePlayData playData = new GamePlayData(gameRoomEntity.getRemainingCount(), judgeResult);
        return Optional.of(playData);
    }

    private boolean isValidGameRoom(Optional<GameRoomEntity> optGameRoomEntity) {
        if (optGameRoomEntity.isEmpty()) {
            return false;
        }
        GameRoomEntity gameRoomEntity = optGameRoomEntity.get();
        if (gameRoomEntity.getRemainingCount() == 0 || gameRoomEntity.isClosed()) {
            return false;
        }
        return true;
    }

    private void log(Long roomId, String answer, JudgeResult result) {
        GameHistoryEntity gameHistory = GameHistoryEntity.builder()
            .roomId(roomId)
            .answer(answer)
            .strike(result.getStrike())
            .ball(result.getBall())
            .out(result.getOut())
            .build();

        gameHistoryRepository.save(gameHistory);
    }
    
}
