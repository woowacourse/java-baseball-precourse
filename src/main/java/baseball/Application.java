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
        int input = scanner.nextInt();
        if (input != 1 && input != 2) {
            throw new IllegalArgumentException();
        }
        if (input == 2) {
            return GameStatus.quit;
        }
        return GameStatus.play;
    }

    public static Hint checkAnswer(String answer, String submittedAnswer) {

        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) == submittedAnswer.charAt(i)) {
                strike++;
            }
            if (answer.charAt(i) == submittedAnswer.charAt((i + 1) % 3)) {
                ball++;
            }
            if (answer.charAt(i) == submittedAnswer.charAt((i + 2) % 3)) {
                ball++;
            }
        }

        return new Hint(strike, ball);
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
