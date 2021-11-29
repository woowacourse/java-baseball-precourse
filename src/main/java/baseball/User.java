package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class User {
	public ArrayList<Integer> numberGenerator() {
		ArrayList<Integer> userNumbers = new ArrayList<Integer>();
		System.out.print(Message.PLEASE_INPUT);
		String tmpUserNumbers = Console.readLine();

		// 예외처리
		Validation.isRightDigit(tmpUserNumbers);
		Validation.isThreeDigit(tmpUserNumbers);
		Validation.isContainSameDigit(tmpUserNumbers);

		//String -> int
		for (int i = 0; i < 3; i++) {
			userNumbers.add(tmpUserNumbers.charAt(i) - '0');
		}
		return userNumbers;
	}
}
