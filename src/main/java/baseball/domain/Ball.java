package baseball.domain;

import utils.BallGenerator;

import java.util.List;
import java.util.Scanner;

public class Ball {
    private BallGenerator ballGenerator;

    public Ball() {
        this.ballGenerator = new BallGenerator();
    }

    public List<Integer> getComputerBall() {
        return ballGenerator.createComputerBall();
    }

    public List<Integer> getUserBall(Scanner sc) {
        return ballGenerator.createUserBall(sc);
    }
}
