package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getNumber(int min, int max, int length) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        validateLength(input, length);
        validateNumber(input, min, max, length);

        return input;
    }

    private static void validateLength(String number, int length) {
        if (number.length() != length) {
            throw new IllegalArgumentException("3자리 숫자만 입력해주세요.");
        }
    }

    private static void validateNumber(String number, int min, int max, int length) {
        for (int i=0; i<length; i++) {
            char num = number.charAt(i);
            if ((min <= (num - '0') && (num - '0') <= max) == false) {
                throw new IllegalArgumentException("0을 제외한 숫자만 입력해주세요.");
            }
        }
    }
}
