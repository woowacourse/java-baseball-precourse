package baseball;

import java.util.HashMap;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * baseball Application에 필요한 주요 기능들을 method로 저장하는 class
 */
public class BaseballUtil {
	public static ArrayList<Integer> generateAnswer(int size) {
		ArrayList<Integer> answer = new ArrayList<>();
		while (answer.size() < size) {
			int number = Randoms.pickNumberInRange(1, 9);
			// System.out.println(number);
			if(!answer.contains(number)) {
				answer.add(number);
			}
		}
		return answer;
	}

	public static void countScore(ArrayList<Integer> answer, String input, HashMap<String, Integer> score) {
		checkInput(input);
		score.put("strike", 0);
		score.put("ball", 0);
		for(int i = 0; i < 3; i++) {
			if(input.indexOf(answer.get(i)+"") == i) {
				score.put("strike", score.get("strike") + 1);
			} else if(input.contains(answer.get(i) + "")) {
				score.put("ball", score.get("ball") + 1);
			}
		}
		printScore(score);
	}

	private static void checkInput(String input) {
		checkLength(input);
		checkNumber(input);
		checkDuplication(input);
		checkRange(input);
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
		ArrayList<Character> setForCheck = new ArrayList<>();
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

	private static void printScore(HashMap<String, Integer> score) {
		if(score.get("ball") == 0 && score.get("strike") == 0) {
			System.out.print("낫싱");
		}
		if(score.get("ball") > 0) {
			System.out.printf("%d볼 ", score.get("ball"));
		}
		if(score.get("strike") > 0) {
			System.out.printf("%d스트라이크", score.get("strike"));
		}
		System.out.printf("%n");
	}

}
