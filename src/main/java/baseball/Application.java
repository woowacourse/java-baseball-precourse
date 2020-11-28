package baseball;

import java.util.Scanner;
import baseball.modules.GameManager;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        GameManager gameManager = new GameManager(scanner);
        gameManager.run();
    }
}
