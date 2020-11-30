package baseball;

import utils.Validator;

import java.security.cert.Extension;
import java.util.*;

import utils.Validator;
import static utils.Constant.*;
import static utils.Validator.*;

public class Player {

    private Scanner scanner;
    private String balls;

    public Player(Scanner scanner) {
        this.scanner = scanner;
    }

    public void inputBalls(){
        String ballCandidate;
        do{
            System.out.print(INPUT_PLAYER_BALLS);
            ballCandidate = scanner.next();
        }while(isInvalidBall(ballCandidate));
        balls = ballCandidate;
    }

}
