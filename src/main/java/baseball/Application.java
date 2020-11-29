package baseball;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        boolean onGame = true;
        while (onGame) {
            Game game = new Game();
            game.play(scanner);
            onGame = InputChannel.askReGame(scanner);
        }
    }
}
