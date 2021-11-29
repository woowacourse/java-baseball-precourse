package baseball;

public class Computer {

	private RandomNumberPicker randomNumberPicker = new RandomNumberPicker();

	public String getRandomBallNumbers() {
		randomNumberPicker.setRandomBallNumbers();
		return randomNumberPicker.getRandomBallNumbers();
	}
}
