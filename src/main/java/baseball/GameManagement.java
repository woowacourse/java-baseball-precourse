package baseball;

import utils.ThreeDigitsUtils;

import java.util.Scanner;

public class GameManagement {
    private final String QUESTION_FOR_BASEBALL_NUMBER = "숫자를 입력해주세요 : ";
    private final String QUESTION_FOR_RE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String CONGRATUALTION_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private Game game;
    private boolean onGame;

    public GameManagement() {
        this.game = new Game(ThreeDigitsUtils.nextBaseballNumber());
        this.onGame = true;
        System.out.println(game.getTargetNumber());
    }

    public void playGame(Scanner scanner) {
        int guess = askNumber(scanner);
        do {
            printHint(guess);
        } while (!game.isCorrect(guess));
    }

    public boolean isGameFinished(){
        return !this.onGame;
    }

    private int askNumber(Scanner scanner) {
        System.out.print(QUESTION_FOR_BASEBALL_NUMBER);
        int inputInt = toInt(scanner.nextLine());
        if (!ThreeDigitsUtils.isBaseballNumber(inputInt)) {
            throw new IllegalArgumentException("Input should be Distinct Three Digits Integer");
        }
        return inputInt;
    }

    private void printHint(int guess) {
        String hint = game.getHint(guess);
        System.out.println(hint);
    }

    public void askReGame(Scanner scanner) {
        System.out.println(CONGRATUALTION_MESSAGE);
        System.out.println(QUESTION_FOR_RE_GAME);
        this.onGame = answerReGame(scanner.nextLine());
    }

    private boolean answerReGame(String inputString) {
        int inputInt = toInt(inputString);
        if (inputInt == 1) {
            return true;
        }
        if (inputInt == 2) {
            return false;
        }
        throw new IllegalArgumentException("Input should be 1 or 2");
    }

    private int toInt(String inputString) {
        String string = inputString.strip();
        try {
            int InputInt = Integer.parseInt(string);
            return InputInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input should be only Integer");
        }
    }
}
