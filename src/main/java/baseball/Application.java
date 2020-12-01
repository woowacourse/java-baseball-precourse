package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean restartGame;
        do {
            Game game = new Game();
            restartGame = game.playGame(scanner);
        } while(restartGame);
    }
}
