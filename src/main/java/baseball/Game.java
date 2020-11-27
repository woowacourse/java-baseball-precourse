package baseball;

import utils.RandomUtils;
import java.util.Scanner;

public class Game {
    public static void play(Scanner scanner){
        Baseball userBall = new Baseball();
        Baseball opponentBall = new Baseball();
        allocateBallsToPlayers(userBall, opponentBall, scanner);
        System.out.println(userBall.getBaseballs());
        System.out.println(opponentBall.getBaseballs());
        User user = new User(userBall);
        Opponent opponent = new Opponent(opponentBall);
        user.printResult(opponent);
    }

    public static void allocateBallsToPlayers(Baseball userBall, Baseball opponentBall, Scanner scanner){
        while(true){
            printPromptMessage();
            if(userBall.parseBaseball(getUserInput(scanner))){
                break;
            }
        }
        opponentBall.parseBaseball(generateOpponentInput());
    }

    public static void printPromptMessage(){
        System.out.println(Constants.PROMPT_MESSAGE);
    }

    public static String getUserInput(Scanner scanner){
        return scanner.next();
    }

    public static String generateOpponentInput(){
        String baseball = "";
        while(baseball.length() != Constants.VALID_INPUT_LENGTH){
            String ball = Integer.toString(RandomUtils.nextInt(1,9));
            if(baseball.indexOf(ball) == -1){
                baseball+=ball;
            }
        }
        return baseball;
    }
}
