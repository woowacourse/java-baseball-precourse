package baseball;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {

	public static void checkRangeNumbers(char[] input) {
		if (!(input.length == Constant.BASE_BALL_GAME_RANGE)) {
			throw new IllegalArgumentException("잘못된 입력 입니다.");
		}
	}

	public static void checkOverlapInputNumbers(char[] input) {
		HashSet<Character> inputCharSet = new HashSet<>();

		for (int i = 0; i < input.length; i++) {
			inputCharSet.add(input[i]);
		}
		if (!(inputCharSet.size() == Constant.BASE_BALL_GAME_RANGE)) {
			throw new IllegalArgumentException("잘못된 입력 입니다.");
		}
	}

	public static void checkZeroNumbers(char[] input) {

		for (int i = 0; i < input.length; i++) {
			if (input[i] == '0') {
				throw new IllegalArgumentException("잘못된 입력 입니다.");
			}
		}
	}

	public static void checkNotText(char[] input) {
		for (int i = 0; i < input.length; i++) {
			if (!(Character.isDigit(input[i]))) {
				throw new IllegalArgumentException("잘못된 입력 입니다.");
			}
		}
	}
}
