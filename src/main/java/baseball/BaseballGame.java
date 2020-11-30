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
        while (balls.length() < BALLS_LENGTH) {
            int ballCandidate = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            if (isNumberDuplicate(String.valueOf(ballCandidate))) {
                continue;
            } else {
                balls += String.valueOf(ballCandidate);
            }
        }
    }
}
