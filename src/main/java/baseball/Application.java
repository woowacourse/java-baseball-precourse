package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        boolean restart = false;
        GameSystem gameSystem = new GameSystem();

        do {
            gameSystem.playGame(scanner);
            restart = gameSystem.getRestartOption();
        } while (restart);
    }
}
