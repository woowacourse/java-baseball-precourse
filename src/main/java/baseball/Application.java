package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.RandomUtils;

public class Application {

    public enum GameStatus {
        play, quit
    }

    public static int generateAnswer() {
        List<Integer> answer = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++) {
            int currentValue;
            do {
                currentValue = RandomUtils.nextInt(0, 9);
            } while (answer.contains(currentValue));
            answer.add(currentValue);
        }

        int intAnswer = 0;
        for (int i = 0; i < 3; i++) {
            intAnswer += (int) Math.pow(10, i) * answer.get(i);
        }

        return intAnswer;
    }

    public static void playBaseball(int answer, Scanner scanner) {
        throw new IllegalArgumentException();
    }

    public static GameStatus decideNext(Scanner scanner) {
        throw new IllegalArgumentException();
    }

    public static Hint checkAnswer(String answer, String submittedAnswer) {
        return new Hint(0, 0);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        GameStatus currentGameStatus = GameStatus.play;
        while (currentGameStatus.equals(GameStatus.play)) {
            int answer = generateAnswer();
            playBaseball(answer, scanner);
            currentGameStatus = decideNext(scanner);
        }
    }
}
