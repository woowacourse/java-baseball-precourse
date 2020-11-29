package baseball;

import java.security.cert.Extension;
import java.util.*;

import static utils.Constant.*;

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

    private boolean isInvalidBall(String candidate) {
        if(isIncorrectLength(candidate) || ( ! isNumber(candidate))
                || isNumberDuplicate(candidate) || isContainZero(candidate) ){
            return true;
        }
        return false;
    }

    private boolean isNumber(String candidate) {
        try {
            int num = Integer.valueOf(candidate);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean isContainZero(String candidate) {
        if(candidate.contains("0")){
            return true;
        }
        return false;
    }

    private boolean isIncorrectLength(String candidate) {
        if(candidate.length() == BALLS_LENGTH){
            return false;
        }
        return true;
    }

    private boolean isNumberDuplicate(String candidate) {
        List<Character> list = new ArrayList<Character>();
        for(int i=0; i<BALLS_LENGTH; i++){
            list.add(candidate.charAt(i));
        }
        HashSet<Character> hashSet = new HashSet<Character>(list);
        if(hashSet.size() == BALLS_LENGTH){
            return false;
        }
        return true;
    }

}
