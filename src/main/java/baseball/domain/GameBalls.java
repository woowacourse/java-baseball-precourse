package baseball.domain;

import java.util.Arrays;

public class GameBalls {

    public static final int NUMBEROFBALLS = 3;
    private Ball[] sequence;

    @Override
    public String toString() {
        return "GameBalls{" +
            "sequence=" + Arrays.toString(sequence) +
            '}';
    }
}
