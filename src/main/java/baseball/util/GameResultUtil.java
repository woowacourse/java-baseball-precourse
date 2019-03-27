package baseball.util;

import java.util.Arrays;
import java.util.List;

public class GameResultUtil {

    private GameResultUtil() {};

    public static List<Integer> generateResult(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strike = countStrike(userNumbers, computerNumbers);
        int ball = countBall(userNumbers, computerNumbers);

        return Arrays.asList(strike, ball);
    }

    private static int countBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int cntBall = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get((i + 1) % 3))
                    || userNumbers.get(i).equals(computerNumbers.get((i + 2) % 3))) {
                cntBall++;
            }
        }
        return cntBall;
    }

    private static int countStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int cntStrike = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                cntStrike++;
            }
        }
        return cntStrike;
    }


}
