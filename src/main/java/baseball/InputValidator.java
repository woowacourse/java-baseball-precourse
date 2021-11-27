package baseball;

import constants.ExitOption;

public class InputValidator {
    private static final int DIGIT_NUMBER = 3;

    InputValidator() {
    }

    public static boolean checkUserInputIsValid(final String userInput) {

        // 제한된 자리수를 초과할 경우 false 리턴
        if (DIGIT_NUMBER != userInput.length()) {
            return false;
        }

        // 정수가 아니거나 0인 경우 false 리턴
        for (int i = 0; i < DIGIT_NUMBER; i++) {
            char temp = userInput.charAt(i);

            if (!Character.isDigit(temp) || temp == '0') {
                return false;
            }
        }
        return true;
    }

    public static boolean checkExitCommandIsValid(final String userInput){
        for (ExitOption option : ExitOption.values()) {
            if (userInput.equals(option.command())) {
                return true;
            }
        }
        return false;
    }
}
