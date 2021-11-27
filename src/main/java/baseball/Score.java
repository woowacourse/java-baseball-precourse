package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Score {
    private int strike;
    private int ball;

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

    public boolean is_success(int[] answer, int[] input) {
        return Arrays.equals(answer, input);
    }

    public void grade(int[] answer, int[] input) {
        List<Integer> list = Arrays.stream(answer).boxed().collect(Collectors.toList());

        for (int i = 0; i < Constant.NUMBER_OF_NUMBERS; i++) {
            if (answer[i] == input[i]) {
                this.strike++;
                continue;
            }
            if (list.contains(input[i])) {
                this.ball++;
            }
        }
    }

    public void printResult() {
        if (this.ball == 0 && this.strike == 0) {
            System.out.println(Constant.NOTHING);
            return;
        }

        StringBuilder result = new StringBuilder();

        if (this.ball > 0) {
            result.append(this.ball);
            result.append(Constant.BALL);
        }

        if (this.strike > 0) {
            result.append(this.strike);
            result.append(Constant.STRIKE);
        }

        System.out.println(result.toString());
    }

    public void setZero() {
        this.strike = 0;
        this.ball = 0;
    }

}
