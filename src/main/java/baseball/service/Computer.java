package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.constants.RandomNumberConstant;
import camp.nextstep.edu.missionutils.Randoms;
import baseball.dto.CompareResult;

public class Computer {

	private ArrayList<Integer> randomNumberList;

	public Computer() {
		init();
		generateRandomNumbers();
	}

	private void init() {
		randomNumberList = new ArrayList<>();
	}

	private void generateRandomNumbers() {
		while(randomNumberList.size() < RandomNumberConstant.RANDOM_NUMBER_SIZE) {
			int randomNumber = Randoms.pickNumberInRange(RandomNumberConstant.MINIMUM_RANDOM_NUMBER, RandomNumberConstant.MAXIMUM_RANDOM_NUMBER);
			addRandomNumber(randomNumber);
		}
	}

	private void addRandomNumber(int randomNumber) {
		if(checkUnique(randomNumber)) {
			randomNumberList.add(randomNumber);
		}
	}

	private boolean checkUnique(int generatedNumber) {
		return !randomNumberList.contains(generatedNumber);
	}

	public CompareResult compareNumbers(List<Integer> givenNumbers) {
		int strike = 0;
		int ball = 0;
		for(int i = 0; i < RandomNumberConstant.RANDOM_NUMBER_SIZE; i++) {
			if(checkStrike(givenNumbers.get(i), randomNumberList.get(i))) {
				strike++;
			} else if (checkBall(givenNumbers.get(i))){
				ball++;
			}
		}
		return new CompareResult(strike, ball);
	}

	private boolean checkStrike(int givenNumber, int randomNumber) {
		return givenNumber == randomNumber;
	}

	private boolean checkBall(int givenNumber) {
		return randomNumberList.contains(givenNumber);
	}

	public void refresh() {
		randomNumberList.clear();
		generateRandomNumbers();
	}
}
