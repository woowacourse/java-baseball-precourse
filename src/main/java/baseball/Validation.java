package baseball;

public class Validation {

	public static boolean checkInput(String numbers) {
		return isLengthOk(numbers) && isInteger(numbers) && isUnique(numbers);
	}

	public static void checkRestartInput(String request) {
		if (!request.equals("1") && !request.equals("2")) {
			throw new IllegalArgumentException(Message.ERROR_REQUEST_INPUT);
		}
	}

	private static boolean isLengthOk(String numbers) {
		if (numbers.length() != Rules.NUMBER_LENGTH) {
			throw new IllegalArgumentException(Message.ERROR_INPUT_LENGTH);
		}
		return true;
	}

	private static boolean isInteger(String numbers) {
		for (int i = 0; i < Rules.NUMBER_LENGTH; i++) {
			char eachDigit = numbers.charAt(i);
			if (!Character.isDigit(eachDigit) || eachDigit == 0) {
				throw new IllegalArgumentException(Message.ERROR_INPUT_TYPE);
			}
		}
		return true;
	}

	private static boolean isUnique(String numbers) {
		boolean[] usedNumber = new boolean[Rules.END_NUMBER + 1];
		for (int i = 0; i < Rules.NUMBER_LENGTH; i++) {
			int eachDigit = Character.getNumericValue(numbers.charAt(i));
			if (usedNumber[eachDigit]) {
				throw new IllegalArgumentException(Message.ERROR_INPUT_DUPLICATE);
			}
			usedNumber[eachDigit] = true;
		}
		return true;
	}

}
