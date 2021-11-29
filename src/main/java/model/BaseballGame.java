package model;

public class BaseballGame {
	ComputerNumbers computerNumbers;
	PlayerNumbers playerNumbers;

	public BaseballGame() {
		makeAnswerNumbers();
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
}