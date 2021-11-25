package baseball;

public class Verification {

	public static int ofReStartOrExitInput(String input) {

		int integerInput = isInteger(input);

		if (integerInput != 1 && integerInput != 2) {
			throw new IllegalArgumentException("1과 2 중에서 선택해야 합니다.");
		}

		return integerInput;
	}

	public static void ofInput(String input) {

		isInteger(input);

		if (input.length() != 3) {
			throw new IllegalArgumentException("세 자리 수를 입력해야 합니다.");
		}
	}

	private static int isInteger(String input) {

		if (!input.matches("-?\\d+")) {
			throw new IllegalArgumentException("정수를 입력해야 합니다.");
		}

		return Integer.parseInt(input);
	}
}
