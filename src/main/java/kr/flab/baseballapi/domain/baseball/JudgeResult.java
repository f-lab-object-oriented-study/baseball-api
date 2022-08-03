package kr.flab.baseballapi.domain.baseball;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JudgeResult {
    private int strike;
    private int ball;
    private int out;
    
    @JsonIgnore
    public boolean isThreeStrikes() {
        return strike == 3;
    }
}
