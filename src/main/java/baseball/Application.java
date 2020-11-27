package baseball;

import utils.InputValidator;
import utils.InvalidInputException;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {
    private static final int NUM_DIGIT = 3;
    private static final String PLAY_AGAIN_BUTTON = "1";
    private static final String PLAY_END_BUTTON = "2";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        do{
            BaseballGame baseballGame = new BaseballGame(NUM_DIGIT, scanner);
            baseballGame.play();
        }while(checkPlayAgain(scanner));
    }

    private static boolean checkPlayAgain(Scanner SCANNER){
        String answer = askPlayAgain(SCANNER);

        return answer.equals(PLAY_AGAIN_BUTTON);
    }

    private static String askPlayAgain(Scanner SCANNER){
        try{
            String answer = InputView.askPlayAgain(SCANNER);
            InputValidator.isValidPlayAgainAns(answer);
            return answer;
        }catch (InvalidInputException IIE){
            OutputView.printMsg(IIE.getMessage());
            return askPlayAgain(SCANNER);
        }
    }
}
