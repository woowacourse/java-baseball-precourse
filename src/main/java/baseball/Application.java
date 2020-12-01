package baseball;

import view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        do {
            BaseballGame baseballGame = new BaseballGame(scanner);
            baseballGame.play();
        } while (checkPlayAgain(scanner));
    }

    private static boolean checkPlayAgain(Scanner scanner) {
        PlayButton answer = InputView.getPlayAgainButton(scanner);
        return answer.playAgain();
    }
}
