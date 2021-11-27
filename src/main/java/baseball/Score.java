package baseball;

import java.util.Arrays;

public class Score {
    private final int strike;
    private final int ball;

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

    public boolean is_success(int[] answer, int[] input) {
        return Arrays.equals(answer, input);
    }
}
