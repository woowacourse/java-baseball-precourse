package utils;

import java.util.Set;
import java.util.HashSet;

import constants.NumberAttribute;

import camp.nextstep.edu.missionutils.Randoms;


public class NumberGenerator {

	/* 1에서 9까지의 서로 다른 임의의 n 자리 난수를 생성함 */
	public static String generateRandomNumber() {

		Set<Character> randNumSet = new HashSet<>();
		String result = "";
		int numLength = 0;

		while (numLength < NumberAttribute.DIGIT_NUMBER.getValue()) {

			int randomDigit = Randoms.pickNumberInRange(NumberAttribute.MIN_RANGE.getValue(),
				NumberAttribute.MAX_RANGE.getValue());
			char number = Character.forDigit(randomDigit, NumberAttribute.RADIX.getValue());

			if (randNumSet.contains(number)) {
				continue;
			}
			randNumSet.add(number);
			result += number;
			numLength++;

		}
		return result;
	}
}

