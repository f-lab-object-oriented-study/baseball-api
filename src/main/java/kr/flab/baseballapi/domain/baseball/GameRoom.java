package kr.flab.baseballapi.domain.baseball;

import kr.flab.baseballapi.infrastructure.persistence.entity.GameRoomEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameRoom {
    private Long remainingCount;
    private Long answerCount;
    private Game game;
    private boolean closed;

    public GameRoom(Long remainingCount) {
        if (remainingCount <= 0L) {
            throw new IllegalArgumentException("remainingCount must be greater than 0");
        }

        this.remainingCount = remainingCount;
        this.answerCount = 0L;
        game = new Game();
    }

    public static GameRoom fromEntity(GameRoomEntity entity) {
        Long remainingCount = entity.getRemainingCount();
        Long answerCount = entity.getAnswerCount();
        Game game = new Game(entity.getAnswer());
        boolean closed = entity.isClosed();

        return new GameRoom(remainingCount, answerCount, game, closed);
    }

    public JudgeResult judge(String strAnswer) {
        Answer answer = Answer.fromString(strAnswer);
        updateCounts();

        JudgeResult judgeResult = game.judge(answer);
        if (judgeResult.isThreeStrikes()) {
            closed = true;
        }

        return game.judge(answer);
    }

    private void updateCounts() {
        answerCount++;
        remainingCount--;
    }

    public Long getRemainingCount() {
        return remainingCount;
    }

    public Long getAnswerCount() {
        return answerCount;
    }

    public boolean isClosed() {
        return closed;
    }
}
