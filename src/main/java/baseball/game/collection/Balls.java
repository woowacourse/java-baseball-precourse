package baseball.game.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static baseball.application.GameManager.GAME_SIZE;

public class Balls {
    private final List<Ball> balls;

    public Balls(Collection<? extends Integer> ballList) {
        balls = new ArrayList<>();
        if (ballList.size() != GAME_SIZE) {
            throw new IllegalArgumentException();
        }

        for (Integer num : ballList) {
            balls.add(new Ball(num));
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = true;
        Balls other = (Balls) obj;
        for (int i = 0; i < balls.size(); i++) {
            res = balls.get(i).equals(other.balls.get(i));
        }
        return res;
    }

    public boolean isAllMatch(Balls userBalls) {
        int strike = getStrike(userBalls);
        int ball = getBall(userBalls);
        printResult(strike, ball);

        return this.equals(userBalls);
    }

    private int getStrike(Balls userBalls) {
        int res = 0;
        for (int i = 0; i < balls.size(); i++) {
            res += getStrikeNum(balls.get(i),userBalls.balls.get(i));
        }
        return res;
    }

    private int getStrikeNum(Ball ball, Ball other) {
        if (ball.equals(other)) {
            return 1;
        }
        return 0;
    }

    private int getBall(Balls userBalls) {
        int res = 0;
        for (int i = 0; i < balls.size(); i++) {
            res += getBallNum(i, userBalls);
        }
        return res;
    }

    private int getBallNum(int i, Balls userBalls) {
        int res = 0;
        for (int j = 0; j < balls.size(); j++) {
            res += getEqualBallNum(i, j, userBalls.balls.get(j));
        }
        return res;
    }

    private int getEqualBallNum(int i, int j, Ball ball) {
        if (i == j) {
            return 0;
        }
        if (balls.get(i).equals(ball)) {
            return 1;
        }
        return 0;
    }

    private void printResult(int strike, int ball) {
        StringBuilder result = new StringBuilder();
        if (strike != 0) {
            result.append(strike + "스트라이크");
        }
        if (ball != 0) {
            result.append(ball + "볼");
        }
        if (strike == 0 && ball == 0) {
            result.append("낫싱");
        }

        System.out.println(result.toString());
    }
}
