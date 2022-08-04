package com.djyun.oopjavabaseballAPI.domain.entity;

import com.djyun.oopjavabaseballAPI.presentation.response.GameHistoryResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class GameHistories {

    private List<GameHistories> histories;
    private String answer;
    private int strike;
    private int ball;
    private int out;

    public GameHistories(List<GameHistories> histories) {
        this.histories = histories;
    }

    public GameHistories(String answer, int strike, int ball, int out) {
        this.answer = answer;
        this.strike = strike;
        this.ball = ball;
        this.out = out;

    }

}
