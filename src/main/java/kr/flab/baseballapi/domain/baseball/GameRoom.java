package kr.flab.baseballapi.domain.baseball;

import java.util.Optional;

public class GameRoom {
    private int remainingCount;
    private int answerCount;
    private Game game;
    private boolean closed;

    public GameRoom(int remainingCount) {
        if (remainingCount <= 0) {
            throw new IllegalArgumentException("remainingCount must be greater than 0");
        }

        this.remainingCount = remainingCount;
        this.answerCount = 0;
        game = new Game();
    }
    
    public int getRemainingCount() {
        return remainingCount;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public Optional<JudgeResult> judge(Answer answer) {
        if (closed) {
            return Optional.empty();
        }
        
        updateCounts();

        JudgeResult judgeResult = game.judge(answer);
        if (judgeResult.isThreeStrikes()) {
            closed = true;
        }

        return Optional.of(game.judge(answer));
    }

    private void updateCounts() {
        answerCount++;
        remainingCount--;
        if (remainingCount == 0) {
            closed = true;
        }
    }

    public boolean isClosed() {
        return closed;
    }
}
