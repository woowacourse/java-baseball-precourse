package model;

public class BaseballGame {
	ComputerNumbers computerNumbers;

	public BaseballGame() {
		makeAnswerNumbers();
	}

	private void makeAnswerNumbers() {
		computerNumbers = new ComputerNumbers();
	}
}