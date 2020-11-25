package utils;

import java.util.Arrays;

import static baseball.domain.Number.NUMBER_COUNT;

public class InputValidation {

    public InputValidation() {
    }

    public static void validateNumberCount(String num) {
        if(num.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException("입력 값의 길이가 3이 아닙니다.");
        }
    }

    public static void validateNumberRange(String num) {
        boolean isOutOfRange = Arrays.stream(num.split(""))
                .mapToInt(Integer::parseInt)
                .filter(n -> (n > 0 && n < 10))
                .count() != NUMBER_COUNT;
        if(isOutOfRange) {
            throw new IllegalArgumentException("입력 값의 범위를 벗어났습니다.");
        }
    }

    public static void validateNumberDuplicate(String num) {
        boolean isDuplicate = Arrays.stream(num.split(""))
                .distinct()
                .count() != num.length();
        if(isDuplicate) {
           throw new IllegalArgumentException("입력값이 서로 다른 수가 아닙니다.");
        }
    }
}
