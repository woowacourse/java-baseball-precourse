package baseball;

public class UserNumber {

	private static final int NUMBER_LENGTH = 3;
	public String userNumber;

	public UserNumber(String input,STATE userState) {
		isDigit(input);
		if (userState == STATE.GAME_STATE)
		{
			isMatchLength(input);
			isContainZero(input);
			isOverlap(input);
		}

		this.userNumber = input;
	}

	private static boolean isDigit(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	private static boolean isMatchLength(String number) {
		if (number.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	private static boolean isOverlap(String number) {
		char[] userNumber = number.toCharArray();

		if (userNumber[0] == userNumber[1] || userNumber[0] == userNumber[2] || userNumber[1] == userNumber[2]) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	private static boolean isContainZero(String number) {
		String zero = Character.toString('0');

		if (number.contains(zero)) {
			throw new IllegalArgumentException();
		}
		return true;
	}

}
