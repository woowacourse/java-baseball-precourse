package baseball;

import utils.ThreeDigitsUtils;

import java.util.Scanner;

public class GameManagement {
    private static Game game;

    public static void playGame(Scanner scanner) {
        initGame();
        boolean isCorrect = false;
        while (!isCorrect) {
            int guess = askNumber(scanner);
            isCorrect = isCorrect(guess);
        }
    }

    private static void initGame() {
        int targetNumber = ThreeDigitsUtils.nextBaseballNumber();
        game = new Game(targetNumber);
        System.out.println(targetNumber);
    }

    private static int askNumber(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        int inputInt = toInt(scanner.nextLine());
        if (ThreeDigitsUtils.isBaseballNumber(inputInt)) {
            return inputInt;
        }
        throw new IllegalArgumentException("Input should be Distinct Three Digits Integer");
    }

    private static boolean isCorrect(int guess) {
        String hint = game.getHint(guess);
        System.out.println(hint);
        return game.isAnswer(guess);
    }

    public static boolean askReGame(Scanner scanner) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return answerReGame(scanner.nextLine());
    }

    private static boolean answerReGame(String inputString) {
        int inputInt = toInt(inputString);
        if (inputInt == 1) {
            return true;
        }
        if (inputInt == 2) {
            return false;
        }
        throw new IllegalArgumentException("Input should be 1 or 2");
    }

    private static int toInt(String inputString) {
        String string = inputString.strip();
        try {
            int InputInt = Integer.parseInt(string);
            return InputInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input should be Integer");
        }
    }
}
