package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_BASEBALL_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WRONG_INPUT_MESSAGE = "잘못 입력하셨습니다. 숫자를 다시 입력해주세요 : ";
    private static final char MINIMUM_BASEBALL_NUMBER = '1';
    private static final char MAXIMUM_BASEBALL_NUMBER = '9';
    private static final int NONE_DUPLICATED_NUMBER_COUNTS = 3;

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
}
