package baseball;

import utils.RandomUtils;
import utils.Validator;

import static utils.Constant.*;

public class User {

    protected String balls;

    public User() {
        balls = INITIAL_BALLS;
    }

    public String getBalls() {
        return balls;
    }

    protected boolean isValidBalls(String candidate){
        try {
            balls = Validator.getValidateBall(String.valueOf(candidate));
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
