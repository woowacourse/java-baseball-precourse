package baseball;

public class InputChecker {
	/**
	 * 특정 문자열이 3자리 수인지 확인하는 메서드
	 * @param inputNumber
	 */
	public static void checkStringIsThreeNumbers(String inputNumber) {
		// inputNumber가 3자리인지 확인
		if (inputNumber.length() != 3) {
			throw new IllegalArgumentException("3자리 수가 아닙니다.");
		}

		// inputNumber가 숫자로 이루어진 문자열인지 확인
		for (int i = 0; i < inputNumber.length(); i++) {
			if (!Character.isDigit(inputNumber.charAt(i))) {
				throw new IllegalArgumentException("숫자가 아닙니다.");
			}
		}
	}

	/**
	 * 특정 문자열이 1 또는 2인지 확인하는 메서드
	 * @param inputNumber
	 */
	public static void checkStringIsOneOrTwo(String inputNumber) {
		if (inputNumber.length() != 1) {
			throw new IllegalArgumentException("1자리 수가 아닙니다.");
		}

		if (inputNumber != "1" && inputNumber != "2") {
			throw new IllegalArgumentException("1또는 2가 아닙니다.");
		}
	}
}
