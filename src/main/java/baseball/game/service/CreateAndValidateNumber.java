package baseball.game.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class CreateAndValidateNumber {

	public static int createRandomNumber() {

		int number = Randoms.pickNumberInRange(100, 999);

		if (!validateCreateNumber(String.valueOf(number))) {
			return createRandomNumber();
		}

		return number;
	}

	private static boolean validateCreateNumber(String inputString) {

		final String regex = "[1-9]+";

		if (!inputString.matches(regex)) {
			return false;
		}

		Set<String> inputSet = new HashSet<>(Arrays.asList(inputString.split("")));
		if (inputSet.size() != 3) {
			return false;
		}

		return true;
	}
}
