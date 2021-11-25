package service;

import camp.nextstep.edu.missionutils.Randoms;
import constants.Constants;

public class Computer {

	private Integer [] randomNumberList = new Integer[Constants.RANDOM_NUMBER_SIZE];

	public Computer() {
		generateRandomNumber();
	}

	private void generateRandomNumber() {
		for(int i = 0; i < Constants.RANDOM_NUMBER_SIZE; i++) {
			int random = Randoms.pickNumberInRange(Constants.START_NUMBER, Constants.END_NUMBER);
			randomNumberList[i] = random;
		}
	}

	public void printRandomNumberList() {
		for(int i = 0; i <Constants.RANDOM_NUMBER_SIZE; i++) {
			System.out.println(randomNumberList[i]);
		}
	}
}
