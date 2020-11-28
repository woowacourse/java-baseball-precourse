package baseball;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        boolean playing = true;

        final Scanner scanner = new Scanner(System.in);
        Game newGame = new Game();

        while (playing) {
            newGame.startGame(scanner);
        }
        scanner.close();
    }

}
