package baseball;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 콘솔에서의 입출력을 담당하는 ConsoleView
 *
 * @author 성시형
 * @version 1.0
 */
public class ConsoleView {
    private final Scanner scanner;
    private final int DIGITS = 3;
    private final char ZERO = '0';
    private final String CONTINUE = "1";
    private final String END = "2";
    private final String ASK_WANT_CONTINUE_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String REQUEST_INPUT_NUMBER_MSG = "숫자를 입력해주세요 : ";
    private final String WRONG_INPUT_MSG = "입력값 형식을 확인해주세요!";

    /**
     * 콘솔 출력에 사용할 스캐너를 받는 생성자 메소드
     * @param scanner 콘솔 출력에 사용할 스캐너
     */
    public ConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * 사용자에게 숫자를 입력할 것을 요청한다.
     * @return 입력받은 숫자
     * @throws IllegalArgumentException 3자릿수가 아니거나 숫자가 아니면 throw
     */
    public String requestNumber() {
        println(REQUEST_INPUT_NUMBER_MSG);
        String inputNumber = scanner.nextLine();
        if (isRightFormatted(inputNumber)) {
            return inputNumber;
        }
        throw new IllegalArgumentException(WRONG_INPUT_MSG);
    }

    /**
     * 사용자에게 게임을 다시 시작할지 물어보는 메세지를 출력하고 1혹은 2를 입력받는다.
     * @return 사용자가 1을 입력하면 true, 2를 입력하면 false
     * @throws IllegalArgumentException 1이나 2가 아닌 값을 입력하면 throw
     */
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

    /**
     * 콘솔에 출력 후 개행한다.
     * @param message 콘솔에 출력할 메세지
     */
    public void println(String message) {
        System.out.println(message);
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
}
