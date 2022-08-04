package kr.flab.baseballapi.presentation.data;

import java.util.List;

import kr.flab.baseballapi.domain.baseball.JudgeResult;
import kr.flab.baseballapi.infrastructure.persistence.entity.GameHistoryEntity;
import kr.flab.baseballapi.presentation.data.common.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameHistoryData implements Data {
    private List<History> histories;

    @Getter
    @AllArgsConstructor
    public static class History {
        String answer;
        JudgeResult result;
        
        public static History fromEntity(GameHistoryEntity entity) {
            return new History(entity.getAnswer(), new JudgeResult(entity.getStrike(), entity.getBall(), entity.getOut()));
        }
    }

}
