package baseball;

import utils.RandomUtils;

import static utils.Constant.*;

public class Computer extends User {

    public Computer() {
        super();
    }

    public void setBalls() {
        while (true) {
            int ballCandidate = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            if (isValidBalls(String.valueOf(ballCandidate))) {
                return;
            }
        }
    }
}
