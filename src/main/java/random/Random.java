package random;

import static constant.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

	public static String createAnswer() {

		int firstNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
		int secondNumber;
		int thirdNumber;

		do {
			secondNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
		} while (secondNumber == firstNumber);

		do {
			thirdNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
		} while (thirdNumber == secondNumber || thirdNumber == firstNumber);

		return firstNumber + "" + secondNumber + thirdNumber;
	}

}
