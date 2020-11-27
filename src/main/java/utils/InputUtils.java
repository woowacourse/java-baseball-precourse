package utils;

import java.util.HashSet;
import java.util.Set;

/**
 * 플레이어의 입력이 정상적인지 비정상적인지 확인하는 클래스
 * 플레이어의 입력이 비정상적이면 예외를 발생시킨다.
 */
public class InputUtils {
    private static final int MINIMUM_INDEX = 0;
    private static final int MAXIMUM_INDEX = 2;
    private static final int PLAYER_SIZE = 3;
    private static final int MINIMUM_ASCII = 49;
    private static final int MAXIMUM_ASCII = 57;
    private static final String ABNORMAL_LENGTH = "3자리보다 짧은 길이의 숫자 또는 긴 길이의 숫자는 입력될 수 없습니다.";
    private static final String ABNORMAL_BOUNDARY = "문자 또는 0은 입력될 수 없습니다.";
    private static final String ABNORMAL_NUMBER = "동일한 숫자는 입력될 수 없습니다.";

    private static boolean validationFlag = true;
    private static boolean lengthFlag = true;
    private static boolean boundaryFlag = true;
    private static boolean numberFlag = true;

    private InputUtils() {
    }

    public static boolean checkValidation(String playerNumber) {
        // 3자리보다 짧은 길이의 숫자 또는 긴 길이의 숫자가 입력되는 경우 (ex. 12, 3216)
        if (!checkLength(playerNumber)) {
            throw new IllegalArgumentException(ABNORMAL_LENGTH);
        }

        // 문자 또는 0이 입력되는 경우 (ex. 2a6, 206)
        if (!checkBoundary(playerNumber)) {
            throw new IllegalArgumentException(ABNORMAL_BOUNDARY);
        }

        // 동일한 숫자가 입력되는 경우 (ex. 115)
        if (!checkNumber(playerNumber)) {
            throw new IllegalArgumentException(ABNORMAL_NUMBER);
        }

        return validationFlag;
    }

    // 3자리보다 짧은 길이의 숫자 또는 긴 길이의 숫자가 입력되었는지 확인하는 함수
    public static boolean checkLength(String playerNumber) {
        if (playerNumber.length() < PLAYER_SIZE || playerNumber.length() > PLAYER_SIZE) {
            lengthFlag = false;
        }

        return lengthFlag;
    }

    // 문자가 입력되었는지 확인하는 함수
    public static boolean checkBoundary(String playerNumber) {
        char[] playerArray = playerNumber.toCharArray();

        for (int i = MINIMUM_INDEX; i <= MAXIMUM_INDEX; i++) {
            if (playerArray[i] < MINIMUM_ASCII || playerArray[i] > MAXIMUM_ASCII) {
                boundaryFlag = false;
            }
        }

        return boundaryFlag;
    }

    // 동일한 숫자가 입력되었는지 확인하는 함수
    public static boolean checkNumber(String playerNumber) {
        Set<Character> playerSet = new HashSet<>();
        char[] playerArray = playerNumber.toCharArray();

        for (int i = MINIMUM_INDEX; i <= MAXIMUM_INDEX; i++) {
            playerSet.add(playerArray[i]);
        }

        if (playerSet.size() < PLAYER_SIZE) {
            numberFlag = false;
        }

        return numberFlag;
    }
}
