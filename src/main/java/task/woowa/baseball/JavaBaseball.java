package task.woowa.baseball;

import java.util.Scanner;

public class JavaBaseball {

	private static final int NUMBER_OF_BALLS = 3;

	private Scanner scanner;

	private void init() {
		scanner = new Scanner(System.in);
	}

	public void launch() {
		init();
		play();
		destroy();
	}

	private void play() {
		boolean hasNextGame = true;
		while (hasNextGame) {
			playGame(getRandomNumber(NUMBER_OF_BALLS));
			endGame();
			hasNextGame = hasNextGame();
		}
	}

	private void playGame(int targetNumber) {
		int inputNumber = 0;
		while (inputNumber != targetNumber) {
			inputNumber = scanner.nextInt();
			int[] ballCount = getBallCount(targetNumber, inputNumber);
			printBallCount(ballCount);
		}
	}

	private void printBallCount(int[] ballCount) {
		System.out.print(ballCount[0] > 0 ? ballCount[0] + "스트라이크 " : "");
		System.out.print(ballCount[1] > 0 ? ballCount[1] + "볼" : "");
		System.out.println(ballCount[0] == ballCount[1] ? "낫싱" : "");
	}

	private int[] getBallCount(int targetNumber, int inputNumber) {
		int[] ballCount = new int[2];
		int[] targetArr = getNumberArr(targetNumber);
		int[] inputArr = getNumberArr(inputNumber);
		ballCount[0] = getStrikes(targetArr, inputArr);
		ballCount[1] = getBalls(targetArr, inputArr);
		return ballCount;
	}

	private int getStrikes(int[] targetArr, int[] inputArr) {
		int strikeCounter = 0;
		for (int i = 0; i < targetArr.length; i++) {
			if (targetArr[i] == inputArr[i]) {
				strikeCounter++;
			}
		}
		return strikeCounter;
	}

	private int getBalls(int[] targetArr, int[] inputArr) {
		int ballCounter = 0;
		for (int i = 0; i < targetArr.length; i++) {
			for (int j = 0; j < inputArr.length; j++) {
				ballCounter += getOneBall(i, j, targetArr, inputArr);
			}
		}
		return ballCounter;
	}

	private int getOneBall(int i, int j, int[] targetArr, int[] inputArr) {
		int result = 0;
		if (i != j && targetArr[i] == inputArr[j]) {
			result++;
		}
		return result;
	}

	private int[] getNumberArr(int number) {
		int[] arr = new int[NUMBER_OF_BALLS];
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = number % 10;
			number /= 10;
		}
		return arr;
	}

	private void endGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	private int getRandomNumber(int digit) {
		int number = (int) (Math.random() * getMultiple(digit) + 1);
		return isProperNumber(number) ? number : getRandomNumber(digit);
	}

	private double getMultiple(int digit) {
		return digit <= 0 ? 1 : 10 * getMultiple(digit - 1);
	}

	private boolean isProperNumber(int number) {
		boolean result = true;
		int[] numArr = getNumberArr(number);
		if (isTooSmall(number)) {
			result = false;
		} else if (hasZero(numArr)) {
			result = false;
		} else {
			result = isNotDuplicated(numArr);
		}
		return result;
	}

	private boolean hasZero(int[] numArr) {
		boolean result = false;
		for (int i = 0; i < numArr.length; i++) {
			if (numArr[i] == 0) {
				result = true;
				break;
			}
		}
		return result;
	}

	private boolean isTooSmall(int number) {
		return number < getMultiple(NUMBER_OF_BALLS-1);
	}

	private boolean isNotDuplicated(int[] numArr) {
		boolean result = true;
		for (int i = 0; i < numArr.length && result; i++) {
			for (int j = 0; j < numArr.length && result; j++) {
				result = isNotSameNumber(i, j, numArr);
			}
		}
		return result;
	}

	private boolean isNotSameNumber(int i, int j, int[] numArr) {
		boolean result = true;
		if (i != j && numArr[i] == numArr[j]) {
			result = false;
		}
		return result;
	}

	private boolean hasNextGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입려하세요.");
		int input = scanner.nextInt();
		return input == 1 ? true : false;
	}

	private void destroy() {
		scanner.close();
	}

	public static void main(String[] args) {
		new JavaBaseball().launch();
	}
}
