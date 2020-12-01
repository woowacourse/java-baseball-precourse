package baseball.view;

import baseball.domain.game.GameResult;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_BASEBALL_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WRONG_INPUT_MESSAGE = "잘못 입력하셨습니다. 숫자를 다시 입력해주세요 : ";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_RESTART_DECISION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String DELIMITER = "";
    private static final char MINIMUM_BASEBALL_NUMBER = '1';
    private static final char MAXIMUM_BASEBALL_NUMBER = '9';
    private static final char RESTART_NUMBER = '1';
    private static final char EXIT_NUMBER = '2';
    private static final int KEEP_PLAYING_NUMBER = 0;
    private static final int VALID_INPUT_BASEBALL_NUMBER_COUNTS = 3;
    private static final int VALID_INPUT_GAME_STATE_LENGTH = 1;
    private static final int FIRST_CHARACTER_INDEX = 0;

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Integer> inputBaseballNumbers() {
        System.out.print(INPUT_BASEBALL_NUMBERS_MESSAGE);
        String inputBaseballNumbers = scanner.nextLine();
        while (!isValidInputBaseballNumbers(inputBaseballNumbers)) {
            inputBaseballNumbers = scanner.nextLine();
        }
        return Arrays.stream(inputBaseballNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean isValidInputBaseballNumbers(String inputBaseballNumbers) {
        try {
            validateInputBaseballNumbers(inputBaseballNumbers);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.print(WRONG_INPUT_MESSAGE);
            return false;
        }
    }

    private void validateInputBaseballNumbers(String inputBaseballNumbers) {
        if (inputBaseballNumbers.length() != VALID_INPUT_BASEBALL_NUMBER_COUNTS) {
            throw new IllegalArgumentException();
        }
        boolean isDuplicated = inputBaseballNumbers.chars()
                .filter(number -> MINIMUM_BASEBALL_NUMBER <= number && number <= MAXIMUM_BASEBALL_NUMBER)
                .distinct()
                .count() != VALID_INPUT_BASEBALL_NUMBER_COUNTS;
        if (isDuplicated) {
            throw new IllegalArgumentException();
        }
    }

    public int inputGameState(GameResult gameResult) {
        if (!gameResult.isEndOfGame()) {
            return KEEP_PLAYING_NUMBER;
        }
        System.out.println(GAME_END_MESSAGE);
        System.out.println(INPUT_RESTART_DECISION_MESSAGE);
        String inputGameState = scanner.nextLine();
        while (!isValidInputGameState(inputGameState)) {
            inputGameState = scanner.nextLine();
        }
        return Integer.parseInt(inputGameState);
    }

    private boolean isValidInputGameState(String inputGameState) {
        try {
            validateInputGameState(inputGameState);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.print(WRONG_INPUT_MESSAGE);
            return false;
        }
    }

    private void validateInputGameState(String inputGameState) {
        if (inputGameState.length() != VALID_INPUT_GAME_STATE_LENGTH) {
            throw new IllegalArgumentException();
        }
        char gameStateNumber = inputGameState.charAt(FIRST_CHARACTER_INDEX);
        if (gameStateNumber != RESTART_NUMBER && gameStateNumber != EXIT_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
