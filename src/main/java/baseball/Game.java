package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Game {

	public void gameStart() {

		boolean gameContinueFlag;

		do {
			gameContinueFlag = isEndGame();
		} while (gameContinueFlag);

	}

	public boolean isEndGame() {

		String playerInput;
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		playerInput = Console.readLine();

		if (playerInput.equals("1")) {
			return true;
		}

		if (playerInput.equals("2")) {
			return false;
		}
		//need: 사용자 입력 예외처리 작업
		return false;

	}

	public boolean judgeResult() {
		return true;
	}

	public int countStrikeAndBall(int[] computerNumber, int[] playerNumber) {
		int numStrike = 0;
		int numBall = 0;

		for (int i = 0; i < 3; i++) {
			if (computerNumber[i] == playerNumber[i]) {
				numStrike += 1;
				continue;
			}
			if (haveValue(computerNumber, playerNumber[i])){
				numBall += 1;
			}
		}
		return numStrike;
	}

	public boolean haveValue(int[] computerNumber, int value) {

		for (int i = 0; i < 3; i++) {
			if (computerNumber[i] == value) {
				return true;
			}
		}
		return false;

	}


}
