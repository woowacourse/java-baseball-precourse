package baseball.domain;

public class Token {
	public static final int LIMITED_LENGTH = 1;
	public static final int FIRST_INDEX = 0;
	public static final int REPLAY = 1;
	public static final int END = 2;

	private int no;

	private Token(String value) {
		this.no = Integer.parseInt(value);
	}

	public static Token from(String value) {
		checkValidation(value);
		return new Token(value);
	}

	private static void checkValidation(String value) {
		checkLength(value);
		checkIsDigit(value);
		checkElement(value);
	}

	private static void checkElement(String value) {
		if (!isValidElement(value)) {
			throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
		}
	}

	private static void checkIsDigit(String value) {
		if (!Character.isDigit(value.charAt(FIRST_INDEX))) {
			throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
		}
	}

	private static void checkLength(String value) {
		if (!isValidLength(value)) {
			throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
		}
	}

	private static boolean isValidLength(String value) {
		return value.length() == LIMITED_LENGTH;
	}

	private static boolean isValidElement(String value) {
		return value.equals(REPLAY) || value.equals(END);
	}

	public boolean isReplay() {
		return no == REPLAY;
	}
}
