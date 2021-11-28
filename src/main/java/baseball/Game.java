package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	Computer computer = new Computer();
	Player player = new Player();

	public void gameStart() {

		boolean gameContinueFlag;

		do {
			goGame();
			gameContinueFlag = isEndGame();
		} while (gameContinueFlag);

	}

	public void goGame() {

		int[] computerNumber = computer.generateRandomNumber();
		boolean isEnd;

		do {
			int[] playerNumber = player.getNumberFromPlayer();
			isEnd = judgeResult(computerNumber, playerNumber);

		} while (isEnd == false);
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
		throw new IllegalArgumentException();

	}

	public boolean judgeResult(int[] computerNumber, int[] playerNumber) {
		int[] numStrikeAndBall;
		boolean endFlag;

		numStrikeAndBall = countStrikeAndBall(computerNumber, playerNumber);
		endFlag = printBallandStrikeResult(numStrikeAndBall);

		return endFlag;
	}

	public int[] countStrikeAndBall(int[] computerNumber, int[] playerNumber) {
		int numStrike = 0;
		int numBall = 0;
		int[] numStrikeAndBall = new int[2];

		for (int i = 0; i < 3; i++) {
			if (computerNumber[i] == playerNumber[i]) {
				numStrike += 1;
				continue;
			}
			if (haveValue(computerNumber, playerNumber[i])) {
				numBall += 1;
			}
		}
		numStrikeAndBall[0] = numStrike;
		numStrikeAndBall[1] = numBall;

		return numStrikeAndBall;
	}

	public boolean haveValue(int[] computerNumber, int value) {

		for (int i = 0; i < 3; i++) {
			if (computerNumber[i] == value) {
				return true;
			}
		}
		return false;

	}

	public boolean printBallandStrikeResult(int[] numStrikeAndBall) {
		int numStrike = numStrikeAndBall[0];
		int numBall = numStrikeAndBall[1];

		if (numStrike == 3) {
			System.out.println("3스트라이크");
			return true;
		}

		if (numStrike == 0 && numBall == 0) {
			System.out.println("낫싱");
			return false;
		}

		if (numBall == 0) {
			System.out.println(numStrike + "스트라이크");
			return false;
		}

		if (numStrike == 0) {
			System.out.println(numBall + "볼");
			return false;
		}

		System.out.println(numBall + "볼 " + numStrike + "스트라이크");
		return false;

	}

}
