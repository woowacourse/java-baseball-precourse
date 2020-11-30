package baseball;

import java.util.Scanner;

public class UserInputNumberGenerator {
    private static final String ASK_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int INPUT_MAX_RANGE = 987;
    private static final int INPUT_MIN_RANGE = 123;
    private static final int PROPER_INPUT_LENGTH = 3;
    private static final int ZERO = 0;

    public static int getUserInput(Scanner scanner) {
        System.out.print(ASK_INPUT_MESSAGE);
        String userInput = scanner.nextLine();
        int userInputNumber = checkUserInput(userInput);
        return userInputNumber;
    }

    /**
     * 메서드 checkUserInput()는 플레이어가 입력한 인풋이 1에서 9까지 중복되지 않는 3자리 수인지 검증
     * @param userInput 플레이어가 콘솔에 입력한 인풋
     * @return userInputNumber userInput이 유효한 3자리 숫자라고 판단하면 이를 정수로 변환해 반환
     */
    private static int checkUserInput(String userInput) {
        checkStringLength(userInput);
        int userInputNumber = inputStringToInteger(userInput);
        checkIntegerRange(userInputNumber);
        checkIntegerDuplicate(userInputNumber);
        checkIntegerHasZero(userInputNumber);
        return userInputNumber;
    }

    private static void checkStringLength(String userInput) {
        /* 3자리 인풋인지 확인한다 */
        if (userInput.length() != PROPER_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static int inputStringToInteger(String userInput) {
        /* 정수로 변환 될 수 있는지 확인한다 */
        int userInputNumber;
        try {
            userInputNumber = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return userInputNumber;
    }

    private static void checkIntegerRange(int userInputNumber) {
        /* 3자리 수인지 확인한다 */
        if(userInputNumber > INPUT_MAX_RANGE || userInputNumber < INPUT_MIN_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkIntegerDuplicate(int userInputNumber) {
        /* 3자리 수 중에서 중복이 있는지 확인한다 */
        int [] userDigits;
        userDigits = NumberSeparator.makeArray(userInputNumber);
        if((userDigits[0] == userDigits[1]) || (userDigits[0] == userDigits[2])
                || (userDigits[1] == userDigits[2])) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkIntegerHasZero(int userInputNumber) {
        /* 3자리 수 중에서 0이 있는지 확인한다 */
        int [] userDigits;
        userDigits = NumberSeparator.makeArray(userInputNumber);
        if(userDigits[1] == ZERO || userDigits[2] == ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
