package view;

import domain.game.GameResult;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_BASEBALL_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WRONG_INPUT_MESSAGE = "잘못 입력하셨습니다. 숫자를 다시 입력해주세요 : ";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_RESTART_DECISION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final char MINIMUM_BASEBALL_NUMBER = '1';
    private static final char MAXIMUM_BASEBALL_NUMBER = '9';
    private static final char RESTART_NUMBER = '1';
    private static final char EXIT_NUMBER = '2';
    private static final int VALID_USER_DECISION_INPUT_LENGTH = 1;
    private static final int NONE_DUPLICATED_NUMBER_COUNTS = 3;
    private static final int KEEP_PLAYING_NUMBER = 0;
    private static final int ZERO_INDEX = 0;

    private InputView() {
    }

    public static String inputBaseballNumbers(Scanner scanner) {
        System.out.print(INPUT_BASEBALL_NUMBERS_MESSAGE);
        String inputBaseballNumbers = scanner.nextLine();
        while (isWrongPattern(inputBaseballNumbers)) {
            System.out.print(WRONG_INPUT_MESSAGE);
            inputBaseballNumbers = scanner.nextLine();
        }
        return inputBaseballNumbers;
    }

    private static boolean isWrongPattern(String inputBaseballNumbers) {
        try {
            validatePattern(inputBaseballNumbers);
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private static void validatePattern(String inputBaseballNumbers) {
        boolean isCorrectPattern = inputBaseballNumbers.chars()
                .filter(number -> MINIMUM_BASEBALL_NUMBER <= number && number <= MAXIMUM_BASEBALL_NUMBER)
                .distinct()
                .count() == NONE_DUPLICATED_NUMBER_COUNTS;
        if (!isCorrectPattern) {
            throw new IllegalArgumentException();
        }
    }

    public static int inputGameState(GameResult gameResult, Scanner scanner) {
        if (!gameResult.isFullScore()) {
            return KEEP_PLAYING_NUMBER;
        }
        System.out.println(GAME_END_MESSAGE);
        System.out.println(INPUT_RESTART_DECISION_MESSAGE);
        return inputUserDecision(scanner);
    }

    private static int inputUserDecision(Scanner scanner) {
        try {
            String input = scanner.nextLine();
            validateUserDecision(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(WRONG_INPUT_MESSAGE);
            return inputUserDecision(scanner);
        }
    }

    private static void validateUserDecision(String input) {
        if (input.length() != VALID_USER_DECISION_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (input.charAt(ZERO_INDEX) != RESTART_NUMBER && input.charAt(ZERO_INDEX) != EXIT_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
