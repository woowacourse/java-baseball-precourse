package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	public static String getNumber(String message, int min, int max, int length) {
		System.out.print(message);
		String input = Console.readLine();

		validateLength(input, length);
		validateNumberRange(input, min, max, length);

		return input;
	}

	private static void validateLength(String number, int length) {
		if (number.length() != length) {
			throw new IllegalArgumentException();
		}
	}

	private static void validateNumberRange(String number, int min, int max, int length) {
		for (int i = 0; i < length; i++) {
			char num = number.charAt(i);
			if (!(min <= (num - '0') && (num - '0') <= max)) {
				throw new IllegalArgumentException();
			}
		}
	}
}
