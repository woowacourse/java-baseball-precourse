package baseball.builder;

import static baseball.constants.GameConstants.Digit.*;
import static baseball.constants.GameConstants.DigitRange.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDigitsBuilder {
	public static List<Integer> getRandomDigitList() {
		boolean[] duplicateCheck = new boolean[END_INCLUSIVE.getNumber() + 1];
		List<Integer> randomDigitList = new ArrayList<>();

		while (randomDigitList.size() < LENGTH.getNumber()) {
			int randomDigit = Randoms.pickNumberInRange(START_INCLUSIVE.getNumber(),
				END_INCLUSIVE.getNumber());
			if (duplicateCheck[randomDigit])
				continue;
			randomDigitList.add(randomDigit);
			duplicateCheck[randomDigit] = true;
		}

		return randomDigitList;
	}
}
