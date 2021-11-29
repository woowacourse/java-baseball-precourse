package domain;

public class Number {
	private final int number;

	public Number(int number) {
		validateRange(number);
		this.number = number;
	}

	private void validateRange(int number) {
		if (number < 1 || number > 9) {
			throw new IllegalArgumentException("숫자는 1과 9 사이어야합니다.");
		}
	}

	public int getNumber() {
		return this.number;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Number) {
			return this.number == ((Number)obj).getNumber();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.number;
	}
}
