package baseball.game.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class CreateAndValidateNumber {

	private static boolean validateCreateNumber(int number) {
		String entireNumber = String.valueOf(number);
		Set<String> entireSet = new HashSet<>(Arrays.asList(entireNumber.split("")));

		if (entireNumber.length() != 3 || entireSet.size() != 3) {
			return false;
		}
		return true;
	}

	public static int createRandomNumber() {
		int number = Randoms.pickNumberInRange(100, 999);
		if (validateCreateNumber(number)) {
			return number;
		} else {
			return createRandomNumber();
		}
	}
}
