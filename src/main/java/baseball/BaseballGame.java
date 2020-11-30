package baseball;

import utils.*;

import java.util.Set;

import static utils.Constant.*;
import static utils.Validator.*;

public class BaseballGame {

    private String balls;

    public BaseballGame() {
        balls = "";
        setBalls();
    }

    private void setBalls() {
        try {
            int ballCandidate = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            balls = Validator.getValidateBall(String.valueOf(ballCandidate));
            return;
        } catch (IllegalArgumentException e) {

        }
    }
}
