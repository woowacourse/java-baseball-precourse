package baseball.game.number;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {

	private static boolean validateCreateNumber(int number) {
		String entireNumber = String.valueOf(number);
		char firstNumber = entireNumber.charAt(0);
		char secondNumber = entireNumber.charAt(1);
		char thirdNumber = entireNumber.charAt(2);
		if (firstNumber == '0' || secondNumber == '0' || thirdNumber == '0') {
			return false;
		} else if (firstNumber == secondNumber || secondNumber == thirdNumber || thirdNumber == firstNumber) {
			return false;
		}
		return true;
	}

	public static int createRandomNumber() {
		int number = Randoms.pickNumberInRange(100, 999);
		if (validateCreateNumber(number)) {
			return number;
		} else {
			return createRandomNumber();
		}
	}
}
