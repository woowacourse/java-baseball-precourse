package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean restart;
        do {
            Game game = new Game();
            restart = game.playGame(scanner);
        } while(restart);
    }
}
