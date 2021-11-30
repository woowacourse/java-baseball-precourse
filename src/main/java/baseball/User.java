package baseball;

import java.lang.String;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class User {
	protected ArrayList<Integer> inputNum() {
		String inputString = Console.readLine();
		Exception.validateInputNum(inputString);
		ArrayList<Integer> userNum = new ArrayList<Integer>();
		for(int i = 0; i < inputString.length(); i++) {
			userNum.add(inputString.charAt(i) - '0');
		}
		return userNum;
	}

	protected int inputChoice() {
		String choice  = Console.readLine();
		Exception.validateInputChoice(choice);
		return Integer.parseInt(choice);
	}
}
