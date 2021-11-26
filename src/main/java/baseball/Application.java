package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	private static String randomNumber;
	private static String inputNumber;

	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
	}

	public static String createRandomNumber() {
		String randomNumber = "";
		while (randomNumber.length() < 3) {
			String num = String.valueOf(Randoms.pickNumberInRange(1, 10));
			if (!randomNumber.contains(num)) {
				randomNumber += num;
			}
		}
		return randomNumber;
	}

	public static int countStrike() {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (randomNumber.charAt(i) == inputNumber.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	public static int countBall() {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (randomNumber.contains(inputNumber.substring(i, i+1)) && randomNumber.charAt(i) != inputNumber.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}
