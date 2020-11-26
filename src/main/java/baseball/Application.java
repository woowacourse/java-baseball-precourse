package baseball;

import java.util.Scanner;

public class Application {

    public enum GameStatus {
        play, quit
    }

    public static int generateAnswer() {
        return -1;
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
