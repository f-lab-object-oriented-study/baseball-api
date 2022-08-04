package kr.flab.baseballapi.domain.baseball;

public class Game {
    private Answer correctAnswer;

    public Game() {
        correctAnswer = RandomAnswerGenerator.generate();
    }

    public Game(String answer) {
        correctAnswer = Answer.fromString(answer);
    }

    public JudgeResult judge(Answer answer) {
        int strikes = correctAnswer.countStrikes(answer);
        int balls = correctAnswer.countBalls(answer);
        int outs = correctAnswer.countOuts(answer);

        return new JudgeResult(strikes, balls, outs);
    }

    public String exportAnswer() {
        return correctAnswer.toString();
    }
}
