package kr.flab.baseballapi.application.data;

import kr.flab.baseballapi.domain.baseball.JudgeResult;
import kr.flab.baseballapi.presentation.data.Data;
import lombok.Getter;

@Getter
public class GamePlayData implements Data {

    private boolean correct;
    private Long remainingCount;
    private int strike;
    private int ball;
    private int out;

    public GamePlayData(Long remainingCount, JudgeResult judgeResult) {
        this.correct = judgeResult.isThreeStrikes();
        this.remainingCount = remainingCount;
        this.strike = judgeResult.getStrike();
        this.ball = judgeResult.getBall();
        this.out = judgeResult.getOut();
    }
    
}
