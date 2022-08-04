package com.djyun.oopjavabaseballAPI.presentation.request;


public class GamePlayRequest {
    private String answer;

    public GamePlayRequest() {
    }

    public GamePlayRequest(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
