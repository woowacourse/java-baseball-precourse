package baseball;

import java.util.HashSet;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;
    private final int DIGITS = 3;
    private final char ZERO = '0';
    private final String CONTINUE = "1";
    private final String END = "2";
    private final String ASK_WANT_CONTINUE_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String REQUEST_INPUT_NUMBER_MSG = "숫자를 입력해주세요 : ";
    private final String WRONG_INPUT_MSG = "입력값 형식을 확인해주세요!";

    public ConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String requestNumber() {
        println(REQUEST_INPUT_NUMBER_MSG);
        String inputNumber = scanner.nextLine();
        if (isRightFormatted(inputNumber)) {
            return inputNumber;
        }
        throw new IllegalArgumentException(WRONG_INPUT_MSG);
    }

    private boolean isRightFormatted(String inputNumber) {
        char[] numbers = inputNumber.toCharArray();
        if (inputNumber.length() != DIGITS) {
            return false;
        }
        if (!isDigitAndNotZero(numbers)) {
            return false;
        }
        if (!isEachDigitDifferent(numbers)) {
            return false;
        }
        return true;
    }

    private boolean isEachDigitDifferent(char[] numbers) {
        HashSet<Character> duplicateChecker = new HashSet<>();
        for (char number : numbers) {
            duplicateChecker.add(number);
        }

        return duplicateChecker.size() == DIGITS;
    }

    private boolean isDigitAndNotZero(char[] numbers) {
        for (char number : numbers) {
            if (!Character.isDigit(number)) {
                return false;
            }

            if (number == ZERO) {
                return false;
            }
        }
        return true;
    }

    public boolean askWantContinue() {
        println(ASK_WANT_CONTINUE_MSG);
        String input = scanner.nextLine();

        if (input.equals(CONTINUE)) {
            return true;
        }

        if (input.equals(END)) {
            return false;
        }

        throw new IllegalArgumentException(WRONG_INPUT_MSG);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
