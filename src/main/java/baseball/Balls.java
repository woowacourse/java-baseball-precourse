package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.RandomUtils;

public class Balls {

    public static final int COUNT_OF_BALLS = 3;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validateSize(balls);
        validateDuplicate(balls);
        this.balls = balls;
    }

    public static Balls generateRandomBalls() {
        List<Ball> balls = new ArrayList<>();
        Ball ball;

        while (balls.size() != COUNT_OF_BALLS) {
            ball = new Ball(RandomUtils.nextInt(1, 9));

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

    public Ball get(int index) {
        return balls.get(index);
    }

    public boolean contains(Ball ball) {
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

    @Override
    public boolean equals(Object obj) {
        Balls balls;
        if (obj instanceof Balls) {
            balls = (Balls) obj;
        } else {
            throw new ClassCastException(this.getClass().getName() + " 객체 끼리만 비교가 가능합니다.");
        }
        return this.balls.equals(balls.balls);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.balls.toArray());
    }
}
