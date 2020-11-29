package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NumberComparator {

    private static final String STRIKE = "strike";
    private static final String BALL = "ball";
    private static final int ONE = 1;
    private static final int ZERO = 0;


    public static Map<String, Integer> compareTwoBalls(
        List<Integer> randomBalls, List<Integer> playerBalls) {
        Map<String, Integer> score = new HashMap<>();

        score.put(STRIKE, 0);
        score.put(BALL, 0);

        checkSameNumberWithSameIndex(score, randomBalls, playerBalls);
        checkSameNumberWithDifferentIndex(score, randomBalls, playerBalls);

        return score;
    }

    private static void checkSameNumberWithSameIndex(Map<String, Integer> score,
        List<Integer> randomBalls, List<Integer> playerBalls) {
        for (int i = 0; i < playerBalls.size(); i++) {
            int plus = plusOneIfContainsAtSameIndex(playerBalls.get(i), randomBalls.get(i));
            score.put(STRIKE, score.get(STRIKE) + plus);
        }
    }

    private static void checkSameNumberWithDifferentIndex(Map<String, Integer> score,
            List<Integer> randomBalls, List<Integer> playerBalls) {
        for (int i = 0; i < playerBalls.size(); i++) {
            int plus = plusOneIfContainsAtDifferentIndex(i, playerBalls.get(i), randomBalls);
            score.put(BALL, score.get(BALL) + plus);
        }
    }

    private static Integer plusOneIfContainsAtSameIndex(Integer playerBall, Integer ComputerBall) {
        if (playerBall.equals(ComputerBall)) {
            return ONE;
        }
        return ZERO;
    }

    private static Integer plusOneIfContainsAtDifferentIndex(Integer index,
            Integer playerBall, List<Integer> randomBalls) {
        if (randomBalls.contains(playerBall) && randomBalls.get(index) != playerBall) {
            return ONE;
        }
        return ZERO;
    }



}
