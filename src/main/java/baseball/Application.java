package baseball;
import java.util.Scanner;

public class Application {
    public static final boolean isPlaying = true;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean playing = isPlaying;
        Game newGame = new Game();

        while (playing) {
            playing = newGame.startGame(scanner);
        }
        scanner.close();
    }

}
