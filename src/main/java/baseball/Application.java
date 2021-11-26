package baseball;

import java.util.HashSet;
import java.lang.IllegalArgumentException;

public class Application {
	static int RANDOM_NUMBER_START = 1;
	static int RANDOM_NUMBER_END = 9;
	static int RANDOM_NUMBER_SIZE = 3;
	static char GAME_INPUT_START = '1';
	static char GAME_INPUT_END = '9';
	static int GAME_INPUT_SIZE = 3;
	static int TOTAL_NUM = 10;
	static int bit = 0;

	public static void main(String[] args) {
		String randomNumber = generateNumber();
		System.out.print("숫자를 입력해주세요 : ");
		String userInput = camp.nextstep.edu.missionutils.Console.readLine();
		checkInput(userInput, GAME_INPUT_START, GAME_INPUT_END, GAME_INPUT_SIZE);
		int strike = calculateStrike(userInput, randomNumber);
		int ball = calculateBall(userInput, randomNumber);
		bit = 0;
		printResult(strike, ball);
	}

	public static String generateNumber() {
		HashSet<Integer> numberSet = new HashSet<>();
		String randomNumber = "";
		while (numberSet.size() < RANDOM_NUMBER_SIZE) {
			numberSet.add(
				camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END));
		}
		for (int eachNum : numberSet) {
			randomNumber += eachNum;
		}
		return randomNumber;
	}

	public static void checkInput(String input, char start, char end, int size) throws IllegalArgumentException {
		boolean numberCondition = true;
		int[] numberCheck = new int[TOTAL_NUM];
		for (int index = 0; index < input.length(); index++) {
			char nowInput = input.charAt(index);
			if (!(start <= nowInput && nowInput <= end) || numberCheck[nowInput - '0'] != 0) {
				numberCondition = false;
				break;
			}
			numberCheck[nowInput - '0'] += 1;
		}
		if (input.length() != size || !numberCondition) {
			throw new IllegalArgumentException();
		}
	}

	public static int calculateStrike(String input, String target) {
		int strike = 0;
		for (int index = 0; index < input.length(); index++) {
			int nowInput = input.charAt(index) - '0';
			int nowTarget = target.charAt(index) - '0';
			if (nowInput == nowTarget) {
				bit |= (1 << index);
				strike += 1;
			}
		}
		return strike;
	}

	public static int calculateBall(String input, String target) {
		int ball = 0;
		int[] numberCnt = new int[TOTAL_NUM];
		for (int index = 0; index < input.length(); index++) {
			int nowInput = input.charAt(index) - '0';
			if ((bit & (1 << index)) == 0) {
				numberCnt[nowInput] += 1;
			}
		}
		for (int index = 0; index < input.length(); index++) {
			int nowTarget = target.charAt(index) - '0';
			if ((bit & (1 << index)) == 0 && numberCnt[nowTarget] > 0) {
				numberCnt[nowTarget] -= 1;
				ball += 1;
			}
		}
		return ball;
	}

	public static void printResult(int strike, int ball) {
		if (strike == 0 && ball == 0) {
			System.out.print("낫싱\n");
		}
		if (strike != 0 && ball == 0) {
			if (strike == RANDOM_NUMBER_SIZE) {
				System.out.print("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
			} else {
				System.out.print(strike + "스트라이크\n");
			}
		}
		if (strike == 0 && ball != 0) {
			System.out.print(ball + "볼\n");
		}
		if (strike != 0 && ball != 0) {
			System.out.print(ball + "볼 " + strike + "스트라이크\n");
		}
	}
}
