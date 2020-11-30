package utils;

public class UserInputValidator {
    public static void isValidNumber(String userInput) throws IllegalArgumentException {
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
    }

    public static void isValidEndCode(String endCode) {
        if (!isNumberFormat(endCode)) {
            throw new IllegalArgumentException("숫자 형식으로 입력해야 합니다.");
        }
        if (!isSingleNumber(endCode)) {
            throw new IllegalArgumentException("한자리 수로 입력 가능합니다.");
        }
        if (!isOneOrTwo(endCode)) {
            throw new IllegalArgumentException("1 또는 2로 선택해야합니다.");
        }
    }

    private static boolean isNumberFormat(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                return false;
            }
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

    private static boolean isSingleNumber(String endCode) {
        return endCode.length() == 1;
    }

    private static boolean isOneOrTwo(String endCode) {
        return endCode.equals("1") || endCode.equals("2");
    }
}
