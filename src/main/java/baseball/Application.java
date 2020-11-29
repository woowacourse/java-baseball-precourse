package baseball;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            BaseballGame baseballGame = new BaseballGame(scanner);
            boolean exit = baseballGame.restartOrExit();
            if (exit) {
                scanner.close();
                return;
            }
        }
    }
}
