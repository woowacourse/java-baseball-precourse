package baseball;

import utils.Validator;

import java.security.cert.Extension;
import java.util.*;

import utils.Validator;
import static utils.Constant.*;
import static utils.Validator.*;

public class Player {

    private Scanner scanner;
    private String balls ;

    public Player(Scanner scanner) {
        this.scanner = scanner;
        balls = "";
    }

    public void inputBalls(){
        while(true){
            try {
                System.out.print(INPUT_PLAYER_BALLS);
                String ballCandidate = scanner.next();
                balls = Validator.getValidateBall(ballCandidate);;
                return;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

}
