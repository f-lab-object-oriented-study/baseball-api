package kr.flab.baseballapi.domain.baseball;

import lombok.Getter;

@Getter
public class Answer {
    private int[] balls;

    public Answer(int firstBall, int secondBall, int thirdBall) {
        balls = new int[] { firstBall, secondBall, thirdBall };
    }

    public static Answer from(String answer) {
        return new Answer(
                Integer.parseInt(answer.substring(0, 1)),
                Integer.parseInt(answer.substring(1, 2)),
                Integer.parseInt(answer.substring(2, 3))
        );
    }

    public int countStrikes(Answer answer) {
        int[] comparedBalls = answer.getBalls();

        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (comparedBalls[i] == this.balls[i]) {
                strikes++;
            }
        }

        return strikes;
    }

    public int countBalls(Answer answer) {
        int[] comparedBalls = answer.getBalls();

        int balls = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                if (comparedBalls[i] == this.balls[j]) {
                    balls++;
                }
            }
        }

        return balls;
    }

    public int countOuts(Answer answer) {
        int[] comparedBalls = answer.getBalls();

        int outs = 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (comparedBalls[i] == this.balls[j]) {
                    outs--;
                    break;
                }
            }
        }

        return outs;
    }

    @Override
    public String toString() {
        return String.valueOf(balls[0]) + balls[1] + balls[2];
    }
}
