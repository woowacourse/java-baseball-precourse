package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	public int[] generateRandomNumber() {

		int[] computerNumber = new int[3];

		for (int i = 0; i < 3; i++) {
			computerNumber[i] = generateOneRandomNumber(computerNumber);
		}

		return computerNumber;

	}

	public int generateOneRandomNumber(int[] computerNumber) {

		int randomNumber;

		while (true) {

			randomNumber = Randoms.pickNumberInRange(1, 9);
			if (isValidateNumber(computerNumber, randomNumber)) {
				break;

			}
		}
		return randomNumber;
	}

	public boolean isValidateNumber(int[] computerNumber, int randomNumber) {
		for (int i = 0; i < computerNumber.length; i++) {
			if (computerNumber[i] == randomNumber) {
				return false;
			}
		}
		return true;
	}
}
