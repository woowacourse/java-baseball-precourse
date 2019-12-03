import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();

        do {
            game.start();
        } while (game.askReplay());
        game.closeScanner();
    }
}
