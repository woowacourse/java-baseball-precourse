package baseball.players;

import baseball.Constant;
import baseball.ball.Ball;
import baseball.ball.BallResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    private int strikeCount;
    private int ballCount;
    private Map<BallResult, Integer> strikeBallCountRecords;

    public Map<BallResult, Integer> getStrikeBallCountRecords() {
        return strikeBallCountRecords;
    }

    public Referee() {
        strikeBallCountRecords = new HashMap<>();
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
        strikeBallCountRecords.put(BallResult.STRIKE, strikeCount);
        strikeBallCountRecords.put(BallResult.BALL, ballCount);
        return strikeBallCountRecords;
    }

    public void totalUserBallsCompare(List<Ball> computerBalls, List<Ball> userBalls) {
        resetCount();
        for (int i = 0; i < Constant.BALL_LIST_SIZE; i++) {
            ballsCompare(computerBalls, userBalls.get(i));
        }
    }

    public void resetCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    public boolean allStrikeCheck() {
        return strikeCount == Constant.BALL_LIST_SIZE;
    }
}
