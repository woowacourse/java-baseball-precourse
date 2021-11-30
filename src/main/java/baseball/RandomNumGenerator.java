package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumGenerator {

	private static final int NUM_LENGTH = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private int[] randomNumber = new int[NUM_LENGTH];

	public RandomNumGenerator() {}

	public int[] getNumber(){
		makeRandomNumber();
		return this.randomNumber;
	}

	public void makeRandomNumber(){
		int currentNumber = 0;
		while (currentNumber < NUM_LENGTH) {
			int temp = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

			if(validateRandomNumber(currentNumber, temp) == true){
				randomNumber[currentNumber] = temp;
				currentNumber++;
			}


		}
	}

	public boolean validateRandomNumber(int currentNumber, int temp){
		for(int i = 0; i < currentNumber; i++){
			if(randomNumber[i] == temp){
				return false;
			}
		}
		return true;
	}

}
