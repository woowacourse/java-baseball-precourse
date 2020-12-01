package baseball;

import utils.Validator;

import java.util.*;

import static utils.Constant.*;

public class Player {

    private Scanner scanner;
    private String balls;

    public Player(Scanner scanner) {
        this.scanner = scanner;
        balls = INITIAL_BALLS;
    }

    public String getBalls() {
        return balls;
    }

    public void inputBalls() {
        try {
            System.out.print(INPUT_PLAYER_BALLS);
            String ballCandidate = scanner.next();
            balls = Validator.getValidateBall(ballCandidate);
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBalls();
        }
    }

}
