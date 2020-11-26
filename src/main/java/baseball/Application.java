package baseball;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        boolean playing = true;
        RandomAnswer newRandomAnswer = new RandomAnswer();
        Integer answer = newRandomAnswer.randomAnswer();
        System.out.println("answer" + answer);

        final Scanner scanner = new Scanner(System.in);
        Game newGame = new Game();

        while (playing) {
            newGame.start(scanner, answer);
        }
    }

}
