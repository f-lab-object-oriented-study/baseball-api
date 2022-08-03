package kr.flab.baseballapi.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.flab.baseballapi.application.data.GamePlayData;
import kr.flab.baseballapi.domain.baseball.JudgeResult;
import kr.flab.baseballapi.infrastructure.persistence.entity.GameRoom;
import kr.flab.baseballapi.infrastructure.persistence.repository.GameRoomRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GamePlayService {

    private final GameRoomRepository gameRoomRepository;

    public Optional<GamePlayData> progress(Long roomId, String answer) {
        Optional<GameRoom> optGameRoom = gameRoomRepository.findById(roomId);
        if (optGameRoom.isEmpty()) {
            return Optional.empty();
        }
        GameRoom gameRoom = optGameRoom.get();
        if (gameRoom.getRemainingCount() == 0) {
            return Optional.empty();
        }

        kr.flab.baseballapi.domain.baseball.GameRoom domainGameRoom = new kr.flab.baseballapi.domain.baseball.GameRoom(gameRoom);
        JudgeResult judgeResult = domainGameRoom.judge(answer);

        gameRoom.setAnswerCount(domainGameRoom.getAnswerCount());
        gameRoom.setRemainingCount(domainGameRoom.getRemainingCount());
        gameRoomRepository.save(gameRoom);

        GamePlayData playData = new GamePlayData(gameRoom.getRemainingCount(), judgeResult);
        return Optional.of(playData);
    }
    
}
