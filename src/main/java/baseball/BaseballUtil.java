package baseball;

import java.util.HashMap;
import java.util.LinkedHashSet;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * baseball Application에 필요한 주요 기능들을 method로 저장하는 class
 */
public class BaseballUtil {
	public static LinkedHashSet<Integer> generateAnswer(int size) {
		LinkedHashSet<Integer> answer = new LinkedHashSet<>();
		while (answer.size() < size) {
			int number = Randoms.pickNumberInRange(1, 9);
			// System.out.println(number);
			answer.add(number);
		}

		return answer;
	}

	public static HashMap<String, Integer> checkAnswer(LinkedHashSet<Integer> answer, String input) {
		checkLength(input);
		checkNumber(input);
		checkDuplication(input);
		checkRange(input);

		HashMap<String, Integer> result = new HashMap<>();
		result.put("strike", countStrike(answer,input));
		result.put("ball", countBall(answer, input) - result.get("strike"));

		return result;
	}

	private static void checkLength(String input) {
		if(input.length() != 3) {
			throw new IllegalArgumentException("3자리를 입력하세요.");
		}
	}

	private static void checkNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력하세요.");
		}
	}

	private static void checkDuplication(String input) {
		LinkedHashSet<Character> setForCheck = new LinkedHashSet<>();
		for(int i = 0; i < input.length(); i++) {
			setForCheck.add(input.charAt(i));
		}
		if(setForCheck.size() != input.length()) {
			throw new IllegalArgumentException("각 자리의 수가 서로 달라야 합니다.");
		}
	}

	private static void checkRange(String input) {
		if(input.contains("0")) {
			throw new IllegalArgumentException("1~9까지의 숫자만 입력하세요.");
		}
	}

	private static int countStrike(LinkedHashSet<Integer> answer, String input) {
		//TODO: Strike 검사 구현
		return 0;
	}

	private static int countBall(LinkedHashSet<Integer> answer, String input) {
		//TODO: Ball 검사 구현
		return 0;
	}
}
