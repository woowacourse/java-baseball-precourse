package random;

import static constant.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

	public static String createAnswer() {

		int firstNumber = Randoms.pickNumberInRange(MAX_NUMBER, MIN_NUMBER);
		int secondNumber;
		int thirdNumber;

		do {
			secondNumber = Randoms.pickNumberInRange(MAX_NUMBER, MIN_NUMBER);
		} while (secondNumber == firstNumber);

		do {
			thirdNumber = Randoms.pickNumberInRange(MAX_NUMBER, MIN_NUMBER);
		} while (thirdNumber == secondNumber || thirdNumber == firstNumber);

		return firstNumber + "" + secondNumber + thirdNumber;
	}

}
