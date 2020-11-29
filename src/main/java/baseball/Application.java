package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        GameManager gameManager = new GameManager(scanner);

        while (gameManager.isGameInProgress()) {
            gameManager.inputUserBaseballs();
            gameManager.outputUserBaseballResult();

            if (gameManager.isGameSet()) {
                gameManager.inputGameProgress();
            }
        }
    }
}
