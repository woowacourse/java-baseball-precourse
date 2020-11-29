package utils;

import baseball.BaseballGame;

public class ValidatorUtils {

    private ValidatorUtils() {
    }

    public static void checkNumbers(String numbers) {
        if (numbers.length() != BaseballGame.THREE_DIGIT) {
            throw new IllegalArgumentException("3자리가 아닙니다. 3자리 숫자를 입력해 주세요.");
        }
        for (int i = 0; i < BaseballGame.THREE_DIGIT; i++) {
            if (!Character.isDigit(numbers.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력해 주세요.");
            }
        }
    }

    public static void checkResponse(String response) {
        if (!response.equals("1") && !response.equals("2")) {
            throw new IllegalArgumentException("1과 2중에 하나만 입력해 주세요.");
        }
    }


}
