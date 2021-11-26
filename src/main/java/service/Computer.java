package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;
import constants.Constants;
import dto.CompareResult;

public class Computer {

	private ArrayList<Integer> randomNumberList;

	public Computer() {
		init();
		generateRandomNumber();
		// generateRandomNumber_test();
	}

	private void init() {
		randomNumberList = new ArrayList<>();
	}

	private void generateRandomNumber() {
		for(int i = 0; i < Constants.RANDOM_NUMBER_SIZE; i++) {
			int random = Randoms.pickNumberInRange(Constants.START_NUMBER, Constants.END_NUMBER);
			randomNumberList.add(random);
		}
	}

	private void generateRandomNumber_test() {
		randomNumberList.add(3);
		randomNumberList.add(4);
		randomNumberList.add(2);
	}

	public CompareResult compareNumbers(List<Integer> givenNumbers) {
		int strike = 0;
		int ball = 0;
		for(int i = 0 ; i < Constants.RANDOM_NUMBER_SIZE; i++) {
			if(checkStrike(givenNumbers.get(i), randomNumberList.get(i))) {
				strike++;
			} else if(checkBall(givenNumbers.get(i))){
				ball++;
			}
		}
		return new CompareResult(strike, ball);
	}

	private boolean checkStrike(int givenNumber, int randomNumber) {
		if(givenNumber == randomNumber) {
			return true;
		}
		return false;
	}

	private boolean checkBall(int givenNumber) {
		return randomNumberList.contains(givenNumber);
	}

	public void refresh() {
		randomNumberList.clear();
		generateRandomNumber();
	}
}
