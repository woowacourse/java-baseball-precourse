package baseball;

import java.lang.IllegalArgumentException;
import java.util.HashSet;

public class Application {
	static int bit = 0;
	static int TOTAL = 10;
	static int GAME_INPUT_SIZE = 3;
	static int RE_GAME_INPUT_SIZE = 1;
	static int RANDOM_NUMBER_START = 1;
	static int RANDOM_NUMBER_END = 9;
	static char GAME_INPUT_START = '0';
	static char GAME_INPUT_END = '9';
	static char RE_GAME_INPUT_START = '1';
	static char RE_GAME_INPUT_END = '2';

	public static void main(String[] args) throws IllegalArgumentException {
		while (true) {
			String targetOutput = getRandomNumber();
			boolean end = false;
			while (!end) {
				System.out.print("숫자를 입력해주세요 : ");
				String userInput = camp.nextstep.edu.missionutils.Console.readLine();
				checkInput(userInput, GAME_INPUT_START, GAME_INPUT_END, GAME_INPUT_SIZE);
				int strike = getStrike(targetOutput, userInput);
				int ball = getBall(targetOutput, userInput);
				printResult(strike, ball);
				bit = 0;
				end = endGame(strike);
			}
			System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
			String reGameInput = camp.nextstep.edu.missionutils.Console.readLine();
			checkInput(reGameInput, RE_GAME_INPUT_START, RE_GAME_INPUT_END, RE_GAME_INPUT_SIZE);
			if (reGameInput.equals("2"))
				break;
		}
	}

	public static String getRandomNumber() {
		HashSet<Integer> numberSet = new HashSet<>();
		String randomNumber = "";
		while (numberSet.size() < GAME_INPUT_SIZE) {
			numberSet.add(
				camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END));
		}
		for (int eachNum : numberSet) {
			randomNumber += eachNum;
		}
		return randomNumber;
	}

	public static void checkInput(String input, char start, char end, int size) {
		boolean numberCondition = true;
		for (int index = 0; index < input.length(); index++) {
			char nowInput = input.charAt(index);
			if (!(start <= nowInput && nowInput <= end)) {
				numberCondition = false;
				break;
			}
		}
		if (input.length() != size || !numberCondition)
			throw new IllegalArgumentException();
	}

	public static int getStrike(String target, String input) {
		int strike = 0;
		for (int index = 0; index < target.length(); index++) {
			if (target.charAt(index) == input.charAt(index)) {
				strike += 1;
				bit |= (1 << index);
			}
		}
		return strike;
	}

	public static int getBall(String target, String input) {
		int ball = 0;
		int[] inputNumberCnt = new int[TOTAL];
		for (int index = 0; index < target.length(); index++) {
			if ((bit & (1 << index)) == 0) {
				int nowInput = input.charAt(index) - '0';
				inputNumberCnt[nowInput] += 1;
			}
		}
		for (int index = 0; index < target.length(); index++) {
			int nowTarget = target.charAt(index) - '0';
			if ((bit & (1 << index)) == 0 && inputNumberCnt[nowTarget] > 0) {
				inputNumberCnt[nowTarget] -= 1;
				ball += 1;
			}
		}
		return ball;
	}

	public static void printResult(int strike, int ball) {
		if (strike == 0 && ball == 0)
			System.out.print("낫싱\n");
		else if (strike == 0)
			System.out.print(ball + "볼\n");
		else if (ball == 0) {
			if (strike == 3)
				System.out.print(strike + "스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
			else
				System.out.print(strike + "스트라이크\n");
		} else {
			System.out.print(ball + "볼 " + strike + "스트라이크\n");
		}
	}

	public static boolean endGame(int strike) {
		if (strike == 3)
			return true;
		return false;
	}
}
