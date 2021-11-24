package baseball.builder;

import java.util.ArrayList;
import java.util.List;

import baseball.constants.GameConstants;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomDigitsBuilder {
	public static List<Integer> getRandomDigitList() {
		boolean[] duplicateCheck = new boolean[GameConstants.DigitRange.END_INCLUSIVE.getNumber() + 1];
		List<Integer> randomDigitList = new ArrayList<>();

		while (randomDigitList.size() < GameConstants.Digit.LENGTH.getNumber()) {
			int randomDigit = Randoms.pickNumberInRange(GameConstants.DigitRange.START_INCLUSIVE.getNumber(),
				GameConstants.DigitRange.END_INCLUSIVE.getNumber());
			if (duplicateCheck[randomDigit])
				continue;
			randomDigitList.add(randomDigit);
			duplicateCheck[randomDigit] = true;
		}

		return randomDigitList;
	}
}
