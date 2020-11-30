package baseball;

import view.InputView;

import java.util.Scanner;

public class Application {
    private static final String PLAY_AGAIN_BUTTON = "1";
    private static final String PLAY_END_BUTTON = "2";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        do{
            BaseballGame baseballGame = new BaseballGame(scanner);
            baseballGame.play();
        }while(checkPlayAgain(scanner));
    }

    private static boolean checkPlayAgain(Scanner scanner){
        String answer = InputView.getPlayAgainButton(scanner);

        return answer.equals(PLAY_AGAIN_BUTTON);
    }
}
