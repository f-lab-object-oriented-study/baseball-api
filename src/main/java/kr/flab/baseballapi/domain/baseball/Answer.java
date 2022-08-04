package kr.flab.baseballapi.domain.baseball;

import lombok.Getter;

@Getter
public class Answer {
    private int[] numbers;

    public Answer(int firstBall, int secondBall, int thirdBall) {
        numbers = new int[] { firstBall, secondBall, thirdBall };
    }

    public static Answer fromString(String answer) {
        return new Answer(
                Integer.parseInt(answer.substring(0, 1)),
                Integer.parseInt(answer.substring(1, 2)),
                Integer.parseInt(answer.substring(2, 3))
        );
    }

    public int countStrikes(Answer answer) {
        int[] comparedNumbers = answer.getNumbers();

        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (comparedNumbers[i] == this.numbers[i]) {
                strikes++;
            }
        }

        return strikes;
    }

    public int countBalls(Answer answer) {
        int[] comparedNumbers = answer.getNumbers();

        int numbers = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                if (comparedNumbers[i] == this.numbers[j]) {
                    numbers++;
                }
            }
        }

        return numbers;
    }

    public int countOuts(Answer answer) {
        int[] comparedNumbers = answer.getNumbers();

        int outs = 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (comparedNumbers[i] == this.numbers[j]) {
                    outs--;
                    break;
                }
            }
        }

        return outs;
    }

    @Override
    public String toString() {
        return String.valueOf(numbers[0]) + numbers[1] + numbers[2];
    }
}
