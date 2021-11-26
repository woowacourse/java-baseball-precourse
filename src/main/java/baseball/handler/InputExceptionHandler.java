package baseball.handler;

import java.util.Arrays;
import java.util.Objects;

/**
 * 유저의 입력에 대한 예외를 처리하는 클래스
 */
public class InputExceptionHandler {

	private static final int MINIMUM_INDEX = 0;
	private static final int MAXIMUM_INDEX = 2;
	private static final int VALID_NUMBER_LENGTH = 3;
	private static final int VALID_MINIMUM_RANGE = 49;
	private static final int VALID_MAXIMUM_RANGE = 57;
	private static final String INVALID_LENGTH_MESSAGE = "잘못된 숫자의 길이가 입력되었습니다.";
	private static final String INVALID_RANGE_MESSAGE = "잘못된 범위의 문자가 입력되었습니다.";
	private static final String INVALID_DUPLICATE_MESSAGE = "중복된 숫자가 입력되었습니다.";
	private static final String INVALID_NUMBER_MESSAGE = "1 또는 2만 입력해주세요.";


	/**
	 * playerNumber에 대한 비정상적인 입력이라면 예외처리를 하는 함수
	 *
	 * @param playerNumber: String
	 */
	public static void validatePlayerNumber(String playerNumber) {

		if (!checkLength(playerNumber, VALID_NUMBER_LENGTH)) {
			throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
		}
		if (!checkRange(playerNumber, VALID_MINIMUM_RANGE, VALID_MAXIMUM_RANGE)) {
			throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
		}
		if (!checkDuplicate(playerNumber)) {
			throw new IllegalArgumentException(INVALID_DUPLICATE_MESSAGE);
		}
	}

	/**
	 * 게임 재시작을 위한 번호 입력에 대한 예외처리를 하는 함수
	 *
	 * @param number: String
	 */
	public static void validateReplay(String number) {
		if (!(Objects.equals(number, "1") || Objects.equals(number, "2"))) {
			throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
		}
	}

	/**
	 * 입력된 숫자가 3자리인지 확인하는 함수
	 *
	 * @param playerNumber: String
	 * @param validLength:  int
	 * @return true or false
	 */
	public static boolean checkLength(String playerNumber, int validLength) {
		return (playerNumber.length() == validLength);
	}

	/**
	 * 입력된 숫자가 1~9 사이의 값인지 확인하는 함수
	 *
	 * @param playerNumber: String
	 * @param minimumRange: int
	 * @param maximumRange: int
	 * @return true or false
	 */
	public static boolean checkRange(String playerNumber, int minimumRange, int maximumRange) {
		char[] playerArray = playerNumber.toCharArray();
		for (int i = MINIMUM_INDEX; i <= MAXIMUM_INDEX; i++) {
			if (playerArray[i] < minimumRange || playerArray[i] > maximumRange) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 입력된 숫자의 중복을 확인하는 함수
	 *
	 * @param playerNumber: String
	 * @return true or false
	 */
	public static boolean checkDuplicate(String playerNumber) {
		return (Arrays.stream(playerNumber.split("")).distinct().count() == playerNumber.length());
	}
}
