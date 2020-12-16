package view;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int NUMBER_LEN = 3;
    private static final String CONTINUE = "1";
    private static final String END = "2";
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CONTINUE_GAME_QUESTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static Scanner scanner;

    public static int getQuestionNumber() {
        try {
            System.out.print(NUMBER_INPUT_MESSAGE);
            String input = scanner.nextLine();
            validateIsNumber(input);
            int number = Integer.parseInt(input);
            validateQuestionNumber(number);
            return number;
        } catch (Exception e) {
            return getQuestionNumber();
        }
    }

    private static void validateQuestionNumber(int number) {
        validateLessThanZero(number);
        validateDigitLength(number);
        validateEachDigitRange(number);
        validateIsDuplicateDigit(number);
    }

    private static void validateIsNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateLessThanZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDigitLength(int number) {
        if (Integer.toString(number).length() != NUMBER_LEN) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateEachDigitRange(int number) {
        while (number > 0) {
            int digit = number % 10;
            if (!(digit >= MIN && digit <= MAX)) {
                throw new IllegalArgumentException();
            }
            number /= 10;
        }
    }

    private static void validateIsDuplicateDigit(int number) {
        Set<Integer> set = new HashSet<>();

        while (number > 0) {
            if (set.contains(number % 10)) {
                throw new IllegalArgumentException();
            }
            set.add(number % 10);
            number /= 10;
        }
    }

    public static int getGameContinueInput() {
        try {
            System.out.println(CONTINUE_GAME_QUESTION_MESSAGE);
            String input = scanner.nextLine();
            validateIsNumber(input);
            validateIsContinueInput(input);
            return Integer.parseInt(input);
        } catch (Exception e) {
            return getGameContinueInput();
        }
    }

    private static void validateIsContinueInput(String input) {
        if (!input.equals(CONTINUE) && !input.equals(END)) {
            throw new IllegalArgumentException();
        }
    }

}
