package baseball;

import java.util.LinkedHashSet;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * baseball Application에 필요한 주요 기능들을 method로 저장하는 class
 */
public class BaseballUtil {
	public static LinkedHashSet<Integer> generateAnswer(int size) {
		LinkedHashSet<Integer> answer = new LinkedHashSet<>();
		while( answer.size() < size ) {
			int number = Randoms.pickNumberInRange(1, 9);
			// System.out.println(number);
			answer.add(number);
		}

		return answer;
	}
}
