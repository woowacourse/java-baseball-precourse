package baseball;

import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
	private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String DECIDING_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String BALL_HINT_MESSAGE = "%d볼";
	private static final String STRIKE_HINT_MESSAGE = "%d스트라이크";
	private static final String OUT_HINT_MESSAGE = "낫싱";

	private int[] enemyNum;
	private int[] playerNum;

	public BaseballGame() {
		initializeNums();
	}

	private void initializeNums() {
		enemyNum = new int[3];
		playerNum = new int[3];
	}

	private void setEnemyNum() {
		int index = 0;
		int temp;
		while (index < 3) {
			temp = Randoms.pickNumberInRange(1, 9);
			int finalTemp = temp;
			if (!IntStream.of(enemyNum).anyMatch(x -> finalTemp == x)) {
				enemyNum[index] = temp;
				index++;
			}
		}
	}

	public void startGame() {
		initializeNums();
		setEnemyNum();
		do {
			takePlayerNum();
		} while (!checkResult());
	}

	private void takePlayerNum() {
		char charPlayerNum;
		System.out.print(INPUT_MESSAGE);
		String userInput = Console.readLine();
		if (userInput.length() != 3) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < 3; i++) {
			charPlayerNum = userInput.charAt(i);
			if (!Character.isDigit(charPlayerNum)) {
				throw new IllegalArgumentException();
			}
			playerNum[i] = Character.getNumericValue(charPlayerNum);
		}
	}

	private boolean checkResult() {
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < 3; i++) {
			if (playerNum[i] == enemyNum[i]) {
				strike++;
				playerNum[i] = -1;
			}
		}
		for (Integer num : playerNum) {
			if (IntStream.of(enemyNum).anyMatch(x -> x == num)) {
				ball++;
			}
		}
		return printResult(strike, ball);
	}

	private boolean printResult(int strike, int ball) {
		if (ball != 0) {
			System.out.print(String.format(BALL_HINT_MESSAGE, ball));
		}
		if (ball != 0 && strike != 0) {
			System.out.print(" ");
		}
		if (strike != 0) {
			System.out.print(String.format(STRIKE_HINT_MESSAGE, strike));
		}
		if (ball + strike == 0) {
			System.out.print(OUT_HINT_MESSAGE);
		}
		System.out.println("");
		if (strike == 3) {
			System.out.println(GAME_CLEAR_MESSAGE);
			return true;
		}
		return false;
	}

	public boolean decideToRestart() {
		String stringRestartValue;
		char charRestartValue;
		System.out.println(DECIDING_RESTART_MESSAGE);
		stringRestartValue = Console.readLine();
		if (stringRestartValue.length() != 1) {
			throw new IllegalArgumentException();
		}
		charRestartValue = stringRestartValue.charAt(0);
		if (charRestartValue == '1') {
			return true;
		} else if (charRestartValue == '2') {
			return false;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
