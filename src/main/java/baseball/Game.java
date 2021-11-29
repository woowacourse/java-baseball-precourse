package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	Computer computer = new Computer();
	Player player = new Player();

	public void startGame() {
		boolean gameContinueFlag;
		do {
			goGame();
			gameContinueFlag = isEndGame();
		} while (gameContinueFlag);
		System.out.println(Constant.END_MESSAGE);
	}

	public void goGame() {
		int[] computerNumber = computer.generateRandomNumber();
		boolean isEnd;
		do {
			System.out.print(Constant.INPUT_MESSAGE);
			int[] playerNumber = player.getNumberFromPlayer();
			isEnd = judgeResult(computerNumber, playerNumber);
		} while (!isEnd);
	}

	public boolean isEndGame() {
		String playerInput;
		System.out.println(Constant.CONTINUE_MESSAGE);
		playerInput = Console.readLine();
		if (playerInput.equals(Constant.RESTART)) {
			return true;
		}
		if (playerInput.equals(Constant.END)) {
			return false;
		}
		throw new IllegalArgumentException();
	}

	public boolean judgeResult(int[] computerNumber, int[] playerNumber) {
		int[] numStrikeAndBall;
		boolean endFlag;
		numStrikeAndBall = countStrikeAndBall(computerNumber, playerNumber);
		endFlag = printBallAndStrikeResult(numStrikeAndBall);
		return endFlag;
	}

	public int[] countStrikeAndBall(int[] computerNumber, int[] playerNumber) {
		int[] numStrikeAndBall = new int[2];
		for (int i = 0; i < 3; i++) {
			if (computerNumber[i] == playerNumber[i]) {
				numStrikeAndBall[0] += 1;
				continue;
			}
			if (haveValue(computerNumber, playerNumber[i])) {
				numStrikeAndBall[1] += 1;
			}
		}
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

	public boolean printBallAndStrikeResult(int[] numStrikeAndBall) {
		int numStrike = numStrikeAndBall[0];
		int numBall = numStrikeAndBall[1];
		if (numStrike == 3) {
			System.out.println(numStrike + Constant.STRIKE);
			return true;
		}
		if (numStrike == 0 && numBall == 0) {
			System.out.println(Constant.NOTHING);
			return false;
		}
		if (numBall == 0) {
			System.out.println(numStrike + Constant.STRIKE);
			return false;
		}
		if (numStrike == 0) {
			System.out.println(numBall + Constant.BALL);
			return false;
		}
		System.out.println(numBall + Constant.BALL + " " + numStrike + Constant.STRIKE);
		return false;
	}
}
