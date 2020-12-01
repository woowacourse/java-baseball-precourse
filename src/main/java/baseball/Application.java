package baseball;

import java.util.Scanner;
import utils.Input;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Input.scanner = scanner;
        NumberBaseBallGame game = new NumberBaseBallGame();
        game.run();
    }

}