package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
	public static void main(String[] args) {

		Number answer = new Number();

		// 입력받은 숫자 입력값 확인 -> ex) 3자리, 숫자 등

		// 입력한 값 정답과 대조

		// 힌트에 따라 결과 출력

	}

	// 게임 재시작여부 확인 함수
}

class Number {
	private final int startRange = 1;
	private final int endRange = 9;
	private final int numberCount = 3;

	int[] number = new int[numberCount];

	Number() {
		int nowRandomNum;
		int nowNumberIndex = 0;

		while (nowNumberIndex < numberCount) {
			nowRandomNum = this.getRandomNumber();

			if (!this.checkArrayContains(number, nowRandomNum)) {
				number[nowNumberIndex++] = nowRandomNum;
			}
		}
	}

	// 생성자: 입력값이 있을 경우 문자열 잘라 인스턴스 생성

	public String toString() {
		return "number: " + this.number[0] + this.number[1] + this.number[2];
	}

	private boolean checkArrayContains(final int[] arr, final int number) {
		for (int value : arr) {
			if (value == number) {
				return true;
			}
		}
		return false;
	}

	private int getRandomNumber() {
		return pickNumberInRange(startRange, endRange);
	}

	// 입력값 확인 함수
}

class Hint extends Number {
	int ball, strike;

	// 볼 카운트 +1 함수

	// 스트라이크 카운트 +1 함수

	// 입력값과 정답 대조 함수

	// 결과 출력 함수수
}