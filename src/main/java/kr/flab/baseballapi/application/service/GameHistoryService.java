package kr.flab.baseballapi.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kr.flab.baseballapi.application.data.GameHistoryData;
import kr.flab.baseballapi.application.data.History;
import kr.flab.baseballapi.infrastructure.persistence.entity.GameHistory;
import kr.flab.baseballapi.infrastructure.persistence.repository.GameHistoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GameHistoryService {

    private final GameHistoryRepository gameHistoryRepository;

    public GameHistoryData progress(Long roomId) {
        List<GameHistory> gameHistories = gameHistoryRepository.findByRoomId(roomId); 
        List<History> histories = gameHistories.stream()
            .map(History::new)
            .collect(Collectors.toList());

        return new GameHistoryData(histories);
    }
    
}
