package kr.flab.baseballapi.application.data;

import kr.flab.baseballapi.domain.baseball.JudgeResult;
import kr.flab.baseballapi.infrastructure.persistence.entity.GameHistory;
import lombok.Getter;

@Getter
public class History {
    String answer;
    JudgeResult result;

    public History(GameHistory gameHistory) {
        this.answer = gameHistory.getAnswer();
        this.result = new JudgeResult(gameHistory.getStrike(), gameHistory.getBall(), gameHistory.getOut());
    }
}
