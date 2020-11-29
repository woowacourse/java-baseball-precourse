package utils;

import baseball.type.BoundaryType;
import baseball.type.SizeType;
import baseball.type.TextType;

import java.util.HashSet;
import java.util.Set;

/** 플레이어의 입력이 정상적인지 비정상적인지 확인하는 클래스 */
public class InputUtils {
    private static boolean lengthFlag = true;
    private static boolean boundaryFlag = true;
    private static boolean numberFlag = true;

    private InputUtils() {
    }

    /**
     * 플레이어의 입력이 정상적인지 비정상적인지 확인하는 함수
     * 플레이어의 입력이 비정상적이면 예외를 발생시킨다.
     *
     * @param playerNumber
     * @return IllegalArgumentException or true
     */
    public static boolean checkValidation(String playerNumber) {
        // 3자리보다 짧은 길이의 숫자 또는 긴 길이의 숫자가 입력되는 경우 (ex. 12, 3216)
        if (!checkLength(playerNumber)) {
            throw new IllegalArgumentException(TextType.INVALID_LENGTH.getText());
        }

        // 문자 또는 0이 입력되는 경우 (ex. 2a6, 206)
        if (!checkBoundary(playerNumber)) {
            throw new IllegalArgumentException(TextType.INVALID_BOUNDARY.getText());
        }

        // 동일한 숫자가 입력되는 경우 (ex. 115)
        if (!checkNumber(playerNumber)) {
            throw new IllegalArgumentException(TextType.INVALID_NUMBER.getText());
        }

        return true;
    }

    /**
     * 3자리보다 짧은 길이의 숫자 또는 긴 길이의 숫자가 입력되었는지 확인하는 함수
     *
     * @param playerNumber
     * @return true or false
     */
    public static boolean checkLength(String playerNumber) {
        if (playerNumber.length() < SizeType.NUMBER_SIZE.getSize() ||
                playerNumber.length() > SizeType.NUMBER_SIZE.getSize()) {
            lengthFlag = false;
        }

        return lengthFlag;
    }

    /**
     * 문자가 입력되었는지 확인하는 함수
     *
     * @param playerNumber
     * @return true or false
     */
    public static boolean checkBoundary(String playerNumber) {
        char[] playerArray = playerNumber.toCharArray();

        for (int i = BoundaryType.MINIMUM_INDEX.getBoundary();
             i <= BoundaryType.MAXIMUM_INDEX.getBoundary(); i++) {
            if (playerArray[i] < BoundaryType.MINIMUM_ASCII.getBoundary() ||
                    playerArray[i] > BoundaryType.MAXIMUM_ASCII.getBoundary()) {
                boundaryFlag = false;
            }
        }

        return boundaryFlag;
    }

    /**
     * 동일한 숫자가 입력되었는지 확인하는 함수
     *
     * @param playerNumber
     * @return true or false
     */
    public static boolean checkNumber(String playerNumber) {
        Set<Character> playerSet = new HashSet<>();
        char[] playerArray = playerNumber.toCharArray();

        for (int i = BoundaryType.MINIMUM_INDEX.getBoundary();
             i <= BoundaryType.MAXIMUM_INDEX.getBoundary(); i++) {
            playerSet.add(playerArray[i]);
        }

        if (playerSet.size() < SizeType.NUMBER_SIZE.getSize()) {
            numberFlag = false;
        }

        return numberFlag;
    }
}
