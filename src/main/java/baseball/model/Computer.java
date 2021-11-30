package baseball.model;

import baseball.utils.RandomNumberPicker;

public class Computer {

	private RandomNumberPicker randomNumberPicker = new RandomNumberPicker();

	public String getRandomBallNumbers() {
		randomNumberPicker.setRandomBallNumbers();
		return randomNumberPicker.getRandomBallNumbers();
	}
}
