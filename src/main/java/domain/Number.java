package domain;

public class Number {

	private final int number;

	public Number(int number) {
		if (validateNumber(number)) {
			this.number = number;
		} else {
			throw new IllegalArgumentException("숫자는 1과 9 사이어야합니다.");
		}
	}

	public Number(String number) {
		try {
			int parsed = Integer.parseInt(number);

			if (validateNumber(parsed)) {
				this.number = parsed;
			} else {
				throw new IllegalArgumentException("숫자는 1과 9 사이어야합니다.");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
		}
	}

	private boolean validateNumber(int number) {
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
