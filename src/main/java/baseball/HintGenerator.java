package baseball;

import java.util.ArrayList;
import java.util.List;

public class HintGenerator {
    private HintGenerator() {
    }

    public static int countStrike(List<Integer> answer, List<Integer> guess) {
        int strikeCount = 0;
        for (int index = 0; index < 3; index++) {
            if (answer.get(index) == guess.get(index)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    public static int countBall(List<Integer> answer, List<Integer> guess) {
        int ballCount = 0;
        for (int index = 0; index < 3; index++) {
            if (answer.contains(guess.get(index))) {
                ballCount += 1;
            }
        }
        return ballCount;
    }
}
