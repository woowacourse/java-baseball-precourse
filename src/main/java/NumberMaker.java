/*
 * NumberMaker.java
 *
 */

import java.util.LinkedHashSet;
import java.util.Random;

/**
 * 랜덤한 3자리의 숫자를 생성하는 클래스
 */
public class NumberMaker {

	/**
	 * 3자리의 랜덤한 숫자 문자열 리턴
	 * @return randomNumber
	 */
	public static String makeRandomNumber() {
		LinkedHashSet<String> linkedSet = new LinkedHashSet<String>(3);
		Random randomMaker = new Random();
		String randomNumber;

		do {
			int number = randomMaker.nextInt(9) + 1;        // 1 ~ 9 생성
			String tempStr = Integer.toString(number);

			linkedSet.add(tempStr);
		} while(linkedSet.size() != 3);
		randomNumber = strArrToStr(linkedSet.toArray(new String[3]));

		return randomNumber;
	}

	/**
	 * 문자열 배열을 문자열로 변환하는 함수
	 * @param strArr
	 * @return str
	 */
	private static String strArrToStr(String[] strArr) {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < strArr.length; i++) {
			str.append(strArr[i]);
		}

		return str.toString();
	}
}
