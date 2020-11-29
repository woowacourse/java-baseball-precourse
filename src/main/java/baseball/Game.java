package baseball;

import utils.ThreeDigitsUtils;

import java.util.Scanner;

public class Game {
    private final String QUESTION_FOR_BASEBALL_NUMBER = "숫자를 입력해주세요 : ";
    private final String QUESTION_FOR_RE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String CONGRATULATION_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private Pitch pitch;

    public Game() {
        int targetNumber = ThreeDigitsUtils.nextBaseballNumber();
        pitch = new Pitch(targetNumber);
        System.out.println(targetNumber);
    }

    public void play(Scanner scanner) {
        while (true){
            int guess = askNumber(scanner);
            printHint(guess);
            if (pitch.isCorrect(guess)) {
                break;
            }
        }
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
        String hint = pitch.getHint(guess);
        System.out.println(hint);
    }

    public boolean askReGame(Scanner scanner) {
        System.out.println(CONGRATULATION_MESSAGE);
        System.out.println(QUESTION_FOR_RE_GAME);
        return answerReGame(scanner.nextLine());
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
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input should be only Integer");
        }
    }
}
