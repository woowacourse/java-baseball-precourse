package baseball;

import java.util.Arrays;

public class Validator {

	public static void checkOverInputNumbers(char[] input) {
		if (input.length > 3) {
			throw new IllegalArgumentException();
		}
	}

	public static void checkOverlapInputNumbers(char[] input) {
		Arrays.sort(input);
		for (int i = 0; i <= input.length; i++) {
			if (input[i] == input[i+1]) {
				throw new IllegalArgumentException();
			}
		}
	}
}
