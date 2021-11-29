package model;

import java.util.regex.Pattern;

public class BaseballGameFlag {
	private static final String NUMBER_PATTERN = "^[1-2]";
	private int gameFlag;

	public BaseballGameFlag() {
		gameFlag = 1;
	}

	public boolean isStartGameFlag() {
		if (gameFlag == 1) {
			return true;
		}
		return false;
	}

	public void chooseGameFlag(String number) {
		isValideNumber(number);
		gameFlag = Integer.parseInt(number);
	}

	private static void isValideNumber(String number) {
		if (!Pattern.matches(NUMBER_PATTERN, number)) {
			throw new IllegalArgumentException("입력한 숫자중 잘못된 숫자(문자, 음수 등)이 있습니다.");
		}

		if (number.length() != 1) {
			throw new IllegalArgumentException("입력한 숫자가 한자리가 아닙니다.");
		}
	}
}
