package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        GamePlay game = new GamePlay(scanner);
        game.run();
    }
}