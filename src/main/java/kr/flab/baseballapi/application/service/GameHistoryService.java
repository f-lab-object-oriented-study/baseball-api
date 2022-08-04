package kr.flab.baseballapi.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kr.flab.baseballapi.infrastructure.persistence.entity.GameHistoryEntity;
import kr.flab.baseballapi.infrastructure.persistence.repository.GameHistoryRepository;
import kr.flab.baseballapi.presentation.data.GameHistoryData;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GameHistoryService {

    private final GameHistoryRepository gameHistoryRepository;

    public GameHistoryData progress(Long roomId) {
        List<GameHistoryEntity> historyEntities = gameHistoryRepository.findByRoomId(roomId); 

        List<GameHistoryData.History> histories = historyEntities.stream()
            .map(GameHistoryData.History::fromEntity)
            .collect(Collectors.toList());

        return new GameHistoryData(histories);
    }
    
}
