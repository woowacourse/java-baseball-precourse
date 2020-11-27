package baseball;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        boolean playing = true;
        String answer = RandomAnswer.randomAnswer();
        System.out.println("answer" + answer);

        final Scanner scanner = new Scanner(System.in);
        Game newGame = new Game();

        while (playing) {
            newGame.startGame(scanner, answer);
        }
    }

}
