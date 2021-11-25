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
		randomNumberList.add(4);
		randomNumberList.add(2);
		randomNumberList.add(5);
	}

	public CompareResult compareNumbers(List<Integer> givenNumbers) {
		int strike = 0;
		int ball = 0;
		for(int i = 0 ; i < Constants.RANDOM_NUMBER_SIZE; i++) {
			if(Objects.equals(givenNumbers.get(i), randomNumberList.get(i))) {
				strike++;
			}else if(randomNumberList.contains(givenNumbers.get(i))) {
				ball++;
			}
		}
		return new CompareResult(strike, ball);
	}

	public void refresh() {
		randomNumberList.clear();
		generateRandomNumber();
	}

	public void printRandomNumberList_test() {
		for(int randomNumber : randomNumberList) {
			System.out.print(randomNumber + " ");
		}
		System.out.println();
	}
}
