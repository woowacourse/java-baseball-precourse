package baseball;

import static constants.BaseBallConstant.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallProvider {
	private static List<Integer> randomNumber;

	public static List<Integer> getRandomNumber() {
		do {
			randomNumber = new ArrayList<>();
			for (int i = 0; i < NUMBER_LENGTH; i++) {
				randomNumber.add(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
			}
		} while (!isUnique(randomNumber) || !isRightLength(randomNumber));
		return randomNumber;
	}

	private static boolean isUnique(List<Integer> randomNumber) {
		Set<Integer> randomDigits = new HashSet<>(randomNumber);
		return randomDigits.size() == 3;
	}

	private static boolean isRightLength(List<Integer> randomNumber) {
		return randomNumber.size() == 3;
	}
}
