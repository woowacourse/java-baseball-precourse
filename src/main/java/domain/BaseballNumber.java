package domain;

public class BaseballNumber {
	private final int number;

	public BaseballNumber(int number) {
		validateNumber(number);
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	private void validateNumber(int number) {
		if (number < 1 || number > 9) {
			throw new IllegalArgumentException("입력은 1부터 9까지의 정수여야합니다.");
		}
	}

	@Override
	public boolean equals(Object obj) {
		boolean answer = false;
		if (obj instanceof BaseballNumber) {
			answer = this.number == ((BaseballNumber) obj).getNumber();
		}
		return answer;
	}
}
