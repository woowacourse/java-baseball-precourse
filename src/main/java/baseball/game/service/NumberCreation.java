package baseball.game.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberCreation {

	public static int createRandomNumber() {

		int number = Randoms.pickNumberInRange(100, 999);

		while (validateCreateNumber(String.valueOf(number))) {
			number = Randoms.pickNumberInRange(100, 999);
		}

		return number;
	}

	private static boolean validateCreateNumber(String inputString) {

		final String regex = "[1-9]+";

		if (!inputString.matches(regex)) {
			return true;
		}

		Set<String> inputSet = new HashSet<>(Arrays.asList(inputString.split("")));
		if (inputSet.size() != 3) {
			return true;
		}

		return false;
	}
}
