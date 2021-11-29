package model;

public class BaseballGame {
	ComputerNumbers computerNumbers;
	PlayerNumbers playerNumbers;

	public BaseballGame(String[] numbers) {
		makeAnswerNumbers();
		playerNumbers = new PlayerNumbers(numbers);
	}

	private void makeAnswerNumbers() {
		computerNumbers = new ComputerNumbers();
	}

	public void passPlayerNumbers(String[] numbers) {
		playerNumbers = new PlayerNumbers(numbers);
	}

	public int giveStrikeCount() {
		return computerNumbers.findNumberOfStrikes(playerNumbers);
	}

	public int giveBallCount() {
		return computerNumbers.findNumberOfBalls(playerNumbers);
	}

	public boolean isNoHint() {
		if (giveStrikeCount() == 0 && giveBallCount() == 0) {
			return true;
		}
		return false;
	}

	public boolean isNotGameOver() {
		if (giveStrikeCount() != 3) {
			return true;
		}
		return false;
	}
}