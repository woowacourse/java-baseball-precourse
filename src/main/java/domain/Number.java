package domain;

public class Number {

	private final int number;

	public Number(int number) {
		if (number < 1 || number > 9) {
			throw new IllegalArgumentException("숫자는 1과 9 사이어야합니다.");
		}
		this.number = number;
	}
}
