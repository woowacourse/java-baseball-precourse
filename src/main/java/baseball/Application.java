package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
	public static void main(String[] args) {

		Number answer = new Number();
		// System.out.println(answer);

		String userInput;
		Number userAnswer;

		while (true) {
			System.out.print("숫자를 입력해주세요 : ");
			userInput = readLine();

			if (!Number.checkInputValue(userInput)) {
				throw new IllegalArgumentException();
			}

			userAnswer = new Number(userInput);
			// System.out.println(userAnswer);
		}

		// 입력한 값 정답과 대조

		// 힌트에 따라 결과 출력

	}

	// 게임 재시작여부 확인 함수
}

class Number {
	private static final int startRange = 1;
	private static final int endRange = 9;
	private static final int numberCount = 3;

	int[] number = new int[numberCount];

	Number() {
		int nowRandomNum;
		int nowNumberIndex = 0;

		while (nowNumberIndex < numberCount) {
			nowRandomNum = this.getRandomNumber();

			if (!Number.checkArrayContains(number, nowRandomNum)) {
				number[nowNumberIndex++] = nowRandomNum;
			}
		}
	}

	Number(String str) {
		for (int i = 0; i < Number.numberCount; i++) {
			number[i] = Integer.parseInt(str.charAt(i) + "");
		}
	}

	public String toString() {
		return "number: " + this.number[0] + this.number[1] + this.number[2];
	}

	private static boolean checkArrayContains(final int[] arr, final int number) {
		for (int value : arr) {
			if (value == number) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkArrayContains(final char[] arr, final char number) {
		for (int value : arr) {
			if (value == number) {
				return true;
			}
		}
		return false;
	}

	private int getRandomNumber() {
		return pickNumberInRange(Number.startRange, Number.endRange);
	}

	static boolean checkInputValue(final String str) {
		if (!Number.checkInputLength(str)) {
			return false;
		}
		if (!Number.checkInputNumber(str)) {
			return false;
		}
		if (!Number.checkEqualNumber(str)) {
			return false;
		}
		return true;
	}

	private static boolean checkInputLength(final String str) {
		return str.length() == Number.numberCount;
	}

	private static boolean checkInputNumber(String str) {
		try {
			int numberValue = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		char[] numberArray = getCharArrayFromString(str);
		return !Number.checkArrayContains(numberArray, '0');
	}

	private static boolean checkEqualNumber(String str) {
		char[] checkEqual = new char[str.length()];
		char[] word = getCharArrayFromString(str);

		for (int i = 0; i < str.length(); i++) {
			if (Number.checkArrayContains(checkEqual, word[i])) {
				return false;
			}
			checkEqual[i] = word[i];
		}

		return true;
	}

	private static char[] getCharArrayFromString(String str) {
		char[] charArray = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			charArray[i] = str.charAt(i);
		}

		return charArray;
	}
}

class Hint extends Number {
	int ball, strike;

	// 볼 카운트 +1 함수

	// 스트라이크 카운트 +1 함수

	// 입력값과 정답 대조 함수

	// 결과 출력 함수수
}