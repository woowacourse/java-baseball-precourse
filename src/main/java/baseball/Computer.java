package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	public int[] generateRandomNumber() {
		int[] computerNumber = new int[Constant.NUMBER_LENGTH];
		for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
			computerNumber[i] = generateOneRandomNumber(computerNumber);
		}
		return computerNumber;
	}

	public int generateOneRandomNumber(int[] computerNumber) {
		int randomNumber;
		while (true) {
			randomNumber = Randoms.pickNumberInRange(Constant.RANDOM_NUMBER_START, Constant.RANDOM_NUMBER_END);
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
