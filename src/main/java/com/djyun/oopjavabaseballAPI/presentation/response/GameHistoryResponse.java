package com.djyun.oopjavabaseballAPI.presentation.response;

import com.djyun.oopjavabaseballAPI.domain.entity.GameHistories;
import com.djyun.oopjavabaseballAPI.domain.entity.GuessResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class GameHistoryResponse {
    private List<GameHistoryResponse> histories;
    private String answer;
    private Result result;

    public GameHistoryResponse(List<GameHistoryResponse> histories) {
        this.histories = histories;
    }
    public GameHistoryResponse(String answer, Result result) {
        this.answer = answer;
        this.result = result;
    }


    public static GameHistoryResponse from(GameHistories histories){
        return new GameHistoryResponse(
                histories.getAnswer(),
                new Result(
                        histories.getStrike(),
                        histories.getBall(),
                        histories.getOut()
                )
        );
    }

    @AllArgsConstructor
    @Getter
    private static class Result {
        private int strike;
        private int ball;
        private int out;

    }
}
