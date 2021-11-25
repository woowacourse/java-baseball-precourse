package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final int NUMBER_LENGTH = 3;
    private static final String USER_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요: ";

    public static String getNumber() {
        System.out.println(USER_INPUT_NUMBER_MESSAGE);
        String userNumber = Console.readLine();

        isDigit(userNumber);
        isMatchLength(userNumber);
        isOverlap(userNumber);
        isContainZero(userNumber);

        return userNumber;
    }

    private static boolean isDigit(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static boolean isMatchLength(String number) {
        if (number.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static boolean isOverlap(String number) {
        char[] userNumber = number.toCharArray();

        if (userNumber[0] == userNumber[1] || userNumber[0] == userNumber[2] || userNumber[1] == userNumber[2]) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static boolean isContainZero(String number) {
        char[] userNumber = number.toCharArray();

        if (userNumber[0] == '0' || userNumber[1] == '0' || userNumber[2] == '0') {
            throw new IllegalArgumentException();
        }
        return true;

    }

    public static void main(String[] args) {
        getNumber();
    }
}
