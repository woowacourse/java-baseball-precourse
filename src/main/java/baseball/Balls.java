package baseball;

import utils.RandomUtils;

import java.util.*;

public class Balls {
    private final List<Ball> balls;
    public static final int COUNT_OF_BALLS = 3;

    public Balls(List<Ball> balls) {
        validateSize(balls);
        validateDuplicate(balls);
        this.balls = balls;
    }

    public GameResult judgeResult(Balls botBalls) {
        // TODO Balls 끼리 비교
        int STRIKE = 0;
        int BALL = 0;

        for (int i = 0; i < COUNT_OF_BALLS; i++) {
            Ball myBall = this.get(i);

            if (myBall.equals(botBalls.get(i))) {
                STRIKE++;
            } else if (botBalls.contains(myBall)) {
                BALL++;
            }
        }
        return new GameResult(STRIKE, BALL);
    }

    public static Balls generateRandomBalls() {
        List<Ball> balls = new ArrayList<>();
        Ball ball;
        int randomNumber;

        while (balls.size() != COUNT_OF_BALLS) {
            randomNumber = RandomUtils.nextInt(1, 9);
            ball = new Ball(randomNumber);

            if (!balls.contains(ball)) {
                balls.add(ball);
            }
        }
        return new Balls(balls);
    }

    public static Balls stringToBalls(String s) {
        char[] chars = s.toCharArray();
        List<Ball> balls = new ArrayList<>();

        for (char c : chars) {
            balls.add(new Ball(c));
        }
        return new Balls(balls);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.balls.toArray());
    }

    private Ball get(int index) {
        return balls.get(index);
    }

    private boolean contains(Ball ball) {
        return this.balls.contains(ball);
    }

    private void validateSize(List<Ball> balls) {
        if (balls.size() != COUNT_OF_BALLS) {
            String msg = String.format("공의 개수는 %d개 여야 합니다.", COUNT_OF_BALLS);
            throw new IllegalArgumentException(msg);
        }
    }

    private void validateDuplicate(List<Ball> balls) {
        Set<Ball> ballSet = new HashSet<>(balls);
        if (ballSet.size() != COUNT_OF_BALLS) {
            String msg = "공들의 숫자는 중복되지 않아야 합니다.";
            throw new IllegalArgumentException(msg);
        }
    }
}
