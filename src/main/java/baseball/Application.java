package baseball;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        boolean onGame = true;

        while (onGame) {
            GameManagement.playGame(scanner);
            onGame = GameManagement.askReGame(scanner);
        }
    }
}
