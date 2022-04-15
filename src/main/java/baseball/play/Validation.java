package baseball.play;

import baseball.util.GameUtil;

public class Validation {

	public Validation(String number) {
		numberCheck(number);
	}

	public void numberCheck(String strNumber) {
		typeNoMatch(strNumber);
		prohibitZero(strNumber);
		duplicateNumber(strNumber);
		int number = Integer.parseInt(strNumber);
		digitNoMatch(number);
		minimumNumberCheck(number);
	}
	
	public void typeNoMatch(String strNumber) {
		try {
			Integer.parseInt(strNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}

	public void prohibitZero(String strNumber) {
		if (strNumber.contains("0")) {
			throw new IllegalArgumentException();
		}
	}
	public void duplicateNumber(String strNumber) {
		String[] numbers = strNumber.split("");

		for(int i = 0; i < numbers.length; i++) {
			if (strNumber.indexOf(numbers[i]) !=
					strNumber.lastIndexOf(numbers[i])) {
				//예외
				throw new IllegalArgumentException();
			}
		}
	}
	public void digitNoMatch(int number) {
		if (GameUtil.getNumberLength(number) != 3) {
			throw new IllegalArgumentException();
		}
	}

	public void minimumNumberCheck(int number) {
		if (number < 1) {
			throw new IllegalArgumentException();
		}
	}





}
