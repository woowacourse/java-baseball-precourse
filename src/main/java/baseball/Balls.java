package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    public static final int MAX_LENGTH = 3;
    private final List<Ball> balls = new ArrayList<>();

    public boolean isFull() {
        return balls.size() == MAX_LENGTH;
    }

    public void add(Ball ball) {
        if (!balls.contains(ball)) {
            balls.add(ball);
        }
    }

    public boolean contains(Ball newBall) {
        return balls.contains(newBall);
    }
}
