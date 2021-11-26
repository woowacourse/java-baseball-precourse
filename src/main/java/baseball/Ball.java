package baseball;

public class Ball {
	private final int position;
	private final int number;

	public Ball(int position, int number) {
		this.position = position;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public int getPosition() {
		return position;
	}
}
