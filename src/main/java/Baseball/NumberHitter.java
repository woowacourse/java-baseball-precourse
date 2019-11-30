package Baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberHitter extends BasePlayer implements Hitter {

    @Override
    public List<Integer> hit() {
        List<Integer> balls = new ArrayList<>();
        for (int i = 0; i < NumberBaseballConfig.Round; i++) {
            int ball = confirmBall(balls);
            balls.add(ball);
        }
        return balls;
    }
    private int confirmBall(List<Integer> balls) {
        Random randomGenerator = new Random();

        int ball = NumberBaseballConfig.MIN_BALL - 1;
        while (!isConfirmed(balls, ball)) {
            //todo: check if it is good
            ball = randomGenerator.ints(NumberBaseballConfig.MIN_BALL, NumberBaseballConfig.MAX_BALL + 1).limit(1).findFirst().getAsInt();
        }

        return ball;
    }
    private boolean isConfirmed(List<Integer> balls, int ball) {
        if (isOutOfRange(ball)) {
            return false;
        }

        return !balls.contains(ball);
    }
    private boolean isOutOfRange(int ball) {
        return ball < NumberBaseballConfig.MIN_BALL || NumberBaseballConfig.MAX_BALL < ball;
    }
}
