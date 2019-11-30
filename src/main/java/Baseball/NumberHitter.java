package Baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberHitter extends BasePlayer implements Hitter {
    //todo: move to config
    private final int ROUND = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    @Override
    public List<Integer> hit() {

        List<Integer> balls = new ArrayList<>();
        for (int i = 0; i < ROUND; i++) {
            int ball = confirmBall(balls);
            balls.add(ball);
        }
        return balls;
    }

    private int confirmBall(List<Integer> balls) {
        Random randomGenerator = new Random();

        //todo: move to config
        int ball = MIN_NUMBER - 1;
        while (!isConfirmed(balls, ball)) {
            //todo: check if it is good
            ball = randomGenerator.ints(MIN_NUMBER, MAX_NUMBER + 1).limit(1).findFirst().getAsInt();
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
        return ball < MIN_NUMBER || MAX_NUMBER < ball;
    }
}
