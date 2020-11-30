package utils;

public class UserInputValidator {
    public static boolean isValidNumber(String userInput) throws IllegalArgumentException {
        if (!isNumberFormat(userInput)) {
            throw new IllegalArgumentException("숫자 형식으로 입력해야 합니다.");
        }
        if (!isThreeNumber(userInput)) {
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
        }
        if (isDuplicatedNumber(userInput)) {
            throw new IllegalArgumentException("숫자를 중복하여 입력 할 수 없습니다.");
        }
        if (isZeroExist(userInput)) {
            throw new IllegalArgumentException("1~9의 숫자를 입력해야 합니다.");
        }
        return true;
    }

    private static boolean isNumberFormat(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean isThreeNumber(String userInput) {
        return userInput.length() == 3;
    }

    private static boolean isDuplicatedNumber(String userInput) {
        return StringHandler.checkDuplication(userInput);
    }

    private static boolean isZeroExist(String userInput) {
        return userInput.contains("0");
    }
}
