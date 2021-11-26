package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
	public static void main(String[] args) {
		Answer rightAnswer = new Answer();
		System.out.println(rightAnswer);

		String userInput;
		Answer answer;
		Hint hint;

		while (true) {
			System.out.print("숫자를 입력해주세요 : ");
			userInput = readLine();
			if (!Answer.checkInputValue(userInput)) {
				throw new IllegalArgumentException();
			}

			answer = new Answer(userInput);

			hint = new Hint();
			hint.compareAnswer(answer, rightAnswer);
			System.out.println(hint);
		}

		// 힌트에 따라 결과 출력

	}

	// 게임 재시작여부 확인 함수
}

class Array {
	static boolean checkArrayContains(final int[] arr, final int number) {
		for (int value : arr) {
			if (value == number) {
				return true;
			}
		}
		return false;
	}

	static boolean checkArrayContains(final char[] arr, final char number) {
		for (int value : arr) {
			if (value == number) {
				return true;
			}
		}
		return false;
	}

	static char[] getCharArrayFromString(String str) {
		char[] charArray = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			charArray[i] = str.charAt(i);
		}

		return charArray;
	}

	static int getIndexFromValue(final int[] arr, final int value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
}

class Answer {
	private static final int startRange = 1;
	private static final int endRange = 9;
	static final int numberCount = 3;

	int[] number = new int[numberCount];

	Answer() {
		int nowRandomNum;
		int nowNumberIndex = 0;

		while (nowNumberIndex < numberCount) {
			nowRandomNum = this.getRandomNumber();

			if (!Array.checkArrayContains(number, nowRandomNum)) {
				number[nowNumberIndex++] = nowRandomNum;
			}
		}
	}

	Answer(String str) {
		for (int i = 0; i < Answer.numberCount; i++) {
			number[i] = Integer.parseInt(str.charAt(i) + "");
		}
	}

	public String toString() {
		return "number: " + this.number[0] + this.number[1] + this.number[2];
	}

	private int getRandomNumber() {
		return pickNumberInRange(Answer.startRange, Answer.endRange);
	}

	static boolean checkInputValue(final String str) {
		if (!Answer.checkInputLength(str)) {
			return false;
		}
		if (!Answer.checkInputNumber(str)) {
			return false;
		}
		if (!Answer.checkEqualNumber(str)) {
			return false;
		}
		return true;
	}

	private static boolean checkInputLength(final String str) {
		return str.length() == Answer.numberCount;
	}

	private static boolean checkInputNumber(String str) {
		try {
			int numberValue = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		char[] numberArray = Array.getCharArrayFromString(str);
		return !Array.checkArrayContains(numberArray, '0');
	}

	private static boolean checkEqualNumber(String str) {
		char[] checkEqual = new char[str.length()];
		char[] word = Array.getCharArrayFromString(str);

		for (int i = 0; i < str.length(); i++) {
			if (Array.checkArrayContains(checkEqual, word[i])) {
				return false;
			}
			checkEqual[i] = word[i];
		}

		return true;
	}
}

class Hint extends Answer {
	int ball, strike;

	public String toString() {
		return "ball: " + this.ball + ", strike: " + this.strike;
	}

	private void addBallCount() {
		this.ball++;
	}

	private void addStrikeCount() {
		this.strike++;
	}

	void compareAnswer(Answer answer, Answer rightAnswer) {
		int nowNumber;

		for (int i = 0; i < Answer.numberCount; i++) {
			nowNumber = answer.number[i];

			if (!Array.checkArrayContains(rightAnswer.number, nowNumber)) {
				continue;
			}
			if (i == Array.getIndexFromValue(rightAnswer.number, nowNumber)) {
				addStrikeCount();
				continue;
			}

			addBallCount();
		}
	}

	// 결과 출력 함수수
}