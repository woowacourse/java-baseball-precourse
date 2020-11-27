package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final GameManager gameManager = new GameManager(scanner);
        gameManager.game();
    }
}
