package domain;

public class Number {
	private final int number;

	public Number(int number) {
		if (validateRange(number)) {
			this.number = number;
		} else {
			throw new IllegalArgumentException("숫자는 1과 9 사이어야합니다.");
		}
	}

	private boolean validateRange(int number) {
		return number >= 1 && number <= 9;
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
