package utils;

import java.util.Arrays;

import static baseball.domain.GameInfomation.*;

public class InputValidation {

    public InputValidation() {
    }

    public static void validateNumberLength(String num) {
        if(num.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력 값의 길이가 3이 아닙니다.");
        }
    }

    public static void validateIsOnlyDigit(String num) {
        boolean isOnlyDigit = num.chars().allMatch(Character::isDigit);
        if(!isOnlyDigit) {
            throw new IllegalArgumentException("입력 값에 숫자가 아닌 값이 입력되었습니다.");
        }
    }

    public static void validateNumberRange(String num) {
        boolean isOutOfRange = Arrays.stream(num.split(""))
                .mapToInt(Integer::parseInt)
                .filter(n -> (n >= NUMBER_RANGE_ONE && n <= NUMBER_RANGE_NINE))
                .count() != NUMBER_LENGTH;
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

    public static void validateSelectGameStatus(int status) {
        if((status != GAME_START) && (status != GAME_STOP)) {
            throw new IllegalArgumentException("입력값이 잘못 되었습니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
