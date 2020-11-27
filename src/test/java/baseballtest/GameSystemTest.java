package baseballtest;

import java.util.Scanner;

import baseball.GameSystem;

public class GameSystemTest {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        boolean restart;
        GameSystem gameSystem = new GameSystem();

        do {
            gameSystem.playGame(scanner);
            restart = gameSystem.getRestartOption();
        } while (restart);
    }
}
