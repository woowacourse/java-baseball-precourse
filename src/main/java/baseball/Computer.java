package baseball;

import utils.RandomUtils;
import utils.Validator;

import static utils.Constant.*;

public class Computer {

    private String balls;

    public Computer() {
        balls = INITIAL_BALLS;
    }

    public String getBalls() {
        return balls;
    }

    public void setBalls() {
        try {
            int ballCandidate = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            balls = Validator.getValidateBall(String.valueOf(ballCandidate));
            return;
        } catch (IllegalArgumentException e) {
            setBalls();
        }
    }
}
