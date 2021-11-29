package model;

import java.util.regex.Pattern;

public class BaseballNumber {
	private int number;
	private static final String NUMBER_PATTERN = "^[1-9]*$";

	public BaseballNumber(int number) {
		this.number = number;
	}

	public BaseballNumber(String number) {
		isValidationNumber(number);
		this.number = Integer.parseInt(number);
	}

	private void isValidationNumber(String number) {
		if (!Pattern.matches(NUMBER_PATTERN, number)) {
			throw new IllegalArgumentException("입력한 숫자중 잘못된 숫자(문자, 음수 등)이 있습니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		BaseballNumber that = (BaseballNumber)o;
		if (this.number == that.number) {
			return true;
		}
		return false;
	}
}
