package baseball;

import view.InputView;

import java.util.Scanner;

public class Application {
    private static final int NUMBER_OF_DIGITS = 3;
    private static final String PLAY_AGAIN_BUTTON = "1";
    private static final String PLAY_END_BUTTON = "2";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        do{
            BaseballGame baseballGame = new BaseballGame(NUMBER_OF_DIGITS, scanner);
            baseballGame.play();
        }while(checkPlayAgain(scanner));
    }

    private static boolean checkPlayAgain(Scanner SCANNER){
        String answer = askPlayAgain(SCANNER);

        return answer.equals(PLAY_AGAIN_BUTTON);
    }

    private static String askPlayAgain(Scanner scanner){
        return InputView.getPlayAgainButton(scanner);
    }
}
