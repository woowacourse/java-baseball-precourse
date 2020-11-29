package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game thisGame = new Game();
        thisGame.start();
        scanner.close();
    }
}
