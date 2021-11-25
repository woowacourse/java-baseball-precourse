package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    private int strikeCount;
    private int ballCount;
    private Map<BallResult, Integer> result;

    public Map<BallResult, Integer> getResult() {
        return result;
    }

    public Referee() {
        result = new HashMap<>();
        result.put(BallResult.STRIKE, 0);
        result.put(BallResult.BALL, 0);
    }

    public BallResult ballCompare(Ball ball1, Ball ball2) {
        if (ball1.equals(ball2)) {
            return BallResult.STRIKE;
        }
        if (ball1.getValue() == ball2.getValue()) {
            return BallResult.BALL;
        }
        return BallResult.NOTHING;
    }

    public Map<BallResult, Integer> ballsCompare(List<Ball> computerBalls, Ball userBall) {
        for (Ball computerBall : computerBalls) {
            BallResult ballResult = ballCompare(computerBall, userBall);
            if (ballResult == BallResult.STRIKE) {
                strikeCount++;
            } else if (ballResult == BallResult.BALL) {
                ballCount++;
            }
        }
        result.put(BallResult.STRIKE, strikeCount);
        result.put(BallResult.BALL, ballCount);
        return result;
    }
}
