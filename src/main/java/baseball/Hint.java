package baseball;

import static baseball.BallType.BALL;
import static baseball.BallType.NOTHING;
import static baseball.BallType.STRIKE;

import java.util.List;

public class Hint {

    private Balls computer;

    public Hint(Balls balls) {
        this.computer = balls;
    }

    public BallType getType(Ball ball, int position) {
        List<Ball> balls = computer.getList();
        if (balls.get(position).equals(ball)) {
            return STRIKE;
        }
        if (balls.contains(ball)) {
            return BALL;
        }
        return NOTHING;
    }
}
