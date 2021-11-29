package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
	private static final int NEW_GAME = 1;
	private static final int QUIT_GAME = 2;

	public static void main(String[] args) {
		// TODO: 두번째 테스트 케이스 타임아웃 발생
		Answer rightAnswer = new Answer();

		// TODO: Game 클래스 만들어서 main 함수 내 실행하는 함수만 작성
		while (true) {
			System.out.print("숫자를 입력해주세요 : ");
			String userInput = readLine();
			Answer.checkInputValue(userInput);

			Answer answer = new Answer(userInput);

			Hint hint = new Hint();
			hint.compareAnswer(answer, rightAnswer);
			hint.showResult();

			if (hint.strike != Answer.NUMBER_COUNT) {
				continue;
			}

			System.out.println(Answer.NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 " + NEW_GAME + ", 종료하려면 " + QUIT_GAME + "를 입력하세요.");
			String newGameAnswer = readLine();

			int newGameAnswerNumber = Application.getNewGameAnswerNumber(newGameAnswer);

			if (newGameAnswerNumber == NEW_GAME) {
				rightAnswer = new Answer();
			} else if (newGameAnswerNumber == QUIT_GAME) {
				break;
			}
		}
	}

	private static int getNewGameAnswerNumber(String str) {
		int intValue;
		try {
			intValue = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}

		if (intValue != 1 && intValue != 2) {
			throw new IllegalArgumentException();
		}

		return intValue;
	}
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
	private static final int START_RANGE = 1;
	private static final int END_RANGE = 9;
	static final int NUMBER_COUNT = 3;

	int[] number = new int[NUMBER_COUNT];

	Answer() {
		int nowRandomNum;
		int nowNumberIndex = 0;

		while (nowNumberIndex < NUMBER_COUNT) {
			nowRandomNum = this.getRandomNumber();

			if (!Array.checkArrayContains(number, nowRandomNum)) {
				number[nowNumberIndex++] = nowRandomNum;
			}
		}
	}

	Answer(String str) {
		for (int i = 0; i < Answer.NUMBER_COUNT; i++) {
			number[i] = Integer.parseInt(str.charAt(i) + "");
		}
	}

	public String toString() {
		return "number: " + this.number[0] + this.number[1] + this.number[2];
	}

	private int getRandomNumber() {
		return pickNumberInRange(Answer.START_RANGE, Answer.END_RANGE);
	}

	static void checkInputValue(final String str) {
		if (!Answer.checkInputLength(str)) {
			throw new IllegalArgumentException();
		}
		if (!Answer.checkInputNumber(str)) {
			throw new IllegalArgumentException();
		}
		if (!Answer.checkEqualNumber(str)) {
			throw new IllegalArgumentException();
		}
	}

	static boolean checkInputLength(final String str) {
		return str.length() == Answer.NUMBER_COUNT;
	}

	static boolean checkInputNumber(String str) {
		try {
			int numberValue = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		char[] numberArray = Array.getCharArrayFromString(str);
		return !Array.checkArrayContains(numberArray, '0');
	}

	static boolean checkEqualNumber(String str) {
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

		for (int i = 0; i < Answer.NUMBER_COUNT; i++) {
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

	void showResult() {
		String result = "";
		if (this.ball != 0) {
			result += this.ball + "볼";
		}

		if (this.strike != 0) {
			if (this.ball != 0) {
				result += " ";
			}
			result += this.strike + "스트라이크";
		}

		if (result.equals("")) {
			result = "낫싱";
		}

		System.out.println(result);
	}
}