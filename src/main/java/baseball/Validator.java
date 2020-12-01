package baseball;

import java.util.Arrays;

public class Validator {

	public static void checkRangeNumbers(char[] input) {
		if (!(input.length == Constant.BASE_BALL_GAME_RANGE)) {
			throw new IllegalArgumentException("잘못된 입력 입니다.");
		}
	}

	public static void checkOverlapInputNumbers(char[] input) {
		Arrays.sort(input);
		
		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] == input[i + 1]) {
				throw new IllegalArgumentException("잘못된 입력 입니다.");
			}
		}
	}
	public static void checkZeroNumbers(char[] input) {
		
		for (int i = 0; i < input.length; i++) {
			if (input[i] == '0') {
				throw new IllegalArgumentException("잘못된 입력 입니다.");
			}
		}
	}
}
