package baseball;

import utils.*;

import java.util.Set;

import static utils.Constant.*;

public class BaseballGame {

    private String balls;

    public BaseballGame() {
        balls = "";
        setBalls();
    }

    private void setBalls() {
        while (balls.length() < BALLS_LENGTH) {
            int ballCandidate = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            if(isNumberDuplicate(ballCandidate)) {
                continue;
            }else{
                balls += String.valueOf(ballCandidate);
            }
        }
    }

    private boolean isNumberDuplicate(int number){
        String candidate = String.valueOf(number);
        if(balls.contains(candidate)){
            return true;
        }
        return false;
    }


}
