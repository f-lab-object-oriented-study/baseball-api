package kr.flab.baseballapi.domain.baseball;

public class GameRoom {
    private Long remainingCount;
    private Long answerCount;
    private Game game;

    public GameRoom(Long remainingCount) {
        if (remainingCount <= 0) {
            throw new IllegalArgumentException("remainingCount must be greater than 0");
        }

        this.remainingCount = remainingCount;
        this.answerCount = 0L;
        game = new Game();
    }

    public GameRoom(kr.flab.baseballapi.infrastructure.persistence.entity.GameRoom gameRoom) {
       this.remainingCount = gameRoom.getRemainingCount();
       this.answerCount = gameRoom.getAnswerCount();
       this.game = new Game(gameRoom.getAnswer());
    }
    
    public Long getRemainingCount() {
        return remainingCount;
    }

    public Long getAnswerCount() {
        return answerCount;
    }

    public JudgeResult judge(String strAnswer) {
        Answer answer = Answer.from(strAnswer);
        updateCounts();

        JudgeResult judgeResult = game.judge(answer);
        if (judgeResult.isThreeStrikes()) {
            remainingCount = 0L;
        }

        return game.judge(answer);
    }

    private void updateCounts() {
        answerCount++;
        remainingCount--;
    }
}
