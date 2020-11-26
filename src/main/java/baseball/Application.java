package baseball;

import java.util.Scanner;
import utils.*;

public class Application {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO 구현 진행

		CheckDuplicate checkDuplicate = new CheckDuplicate();
		String randomNum = checkDuplicate.makeRandomNumber();
		//System.out.println(randomNum);

		CheckInputNumber checkInputNumber = new CheckInputNumber();
		String input = checkInputNumber.inputNumber();
		// System.out.println(checkInputNumber.isValid(inputNum));

		StrikeBallNothingCorrect strikeBallNothingCorrect = new StrikeBallNothingCorrect(input, randomNum);
		boolean test = strikeBallNothingCorrect.correctingNumbers();
		//System.out.println(test);
	}

}
