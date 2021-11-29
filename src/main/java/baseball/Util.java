package baseball;

import java.util.Iterator;
import java.util.LinkedHashSet;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {
	public static String randomNumberGenerator(int startInclusive, int endInclusive, int count) {
		LinkedHashSet<Integer> randomNumber = new LinkedHashSet<>();
		while (randomNumber.size() < count) {
			randomNumber.add(Integer.valueOf(Randoms.pickNumberInRange(startInclusive, endInclusive)));
		}

		Iterator<Integer> randomNumberIter = randomNumber.iterator();
		String resultRandomNumber = "";
		while (randomNumberIter.hasNext()) {
			resultRandomNumber += randomNumberIter.next() + "";
		}

		return resultRandomNumber;
	}
}
