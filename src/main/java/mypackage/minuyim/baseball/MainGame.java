package mypackage.minuyim.baseball;

import mypackage.minuyim.baseball.util.InputNumber;
import mypackage.minuyim.baseball.util.MakeRandomNumber;

public class MainGame {

	public static void main(String[] args) {
		// int[] userNumber;
		int userNumber;
		int[] answerNumber;
		
		InputNumber inputNumberToArray = new InputNumber();
		userNumber = inputNumberToArray.inputNumber();
		
		MakeRandomNumber makeRandomNumber = new MakeRandomNumber();
		answerNumber = makeRandomNumber.makeRandom();

		return;
	}
}