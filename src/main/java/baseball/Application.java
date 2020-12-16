package baseball;

import java.util.Scanner;
import view.InputView;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        InputView.scanner = scanner;
        NumberBaseBallGame game = new NumberBaseBallGame();
        game.run();
    }

}