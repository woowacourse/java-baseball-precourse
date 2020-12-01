package baseball;

import utils.Validator;

import java.util.*;

import static utils.Constant.*;

public class Player extends User {

    private Scanner scanner;

    public Player(Scanner scanner) {
        super();
        this.scanner = scanner;
    }

    public void inputBalls() {
        while (true) {
            System.out.print(INPUT_PLAYER_BALLS);
            String ballCandidate = scanner.next();
            if (isValidBalls(String.valueOf(ballCandidate))) {
                return;
            }
        }


    }

}
