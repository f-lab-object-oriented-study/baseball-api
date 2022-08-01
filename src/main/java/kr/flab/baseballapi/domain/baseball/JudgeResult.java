package kr.flab.baseballapi.domain.baseball;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JudgeResult {
    private int strikes;
    private int balls;
    private int outs;
    
    public boolean isThreeStrikes() {
        return strikes == 3;
    }
}
