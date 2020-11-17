package domain;

import java.util.Objects;

public class BaseballNumber {
	private static final String OUT_OF_RANGE_MESSAGE = "1부터 9까지의 숫자만 가능합니다.";
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private final int baseballNumber;

	public BaseballNumber(int baseballNumber) {
		validateBaseballNumber(baseballNumber);
		this.baseballNumber = baseballNumber;
	}

	private void validateBaseballNumber(int baseballNumber) {
		if (baseballNumber < MIN_NUMBER || baseballNumber > MAX_NUMBER) {
			throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
		}
	}

	@Override
	public String toString() {
		return String.valueOf(baseballNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(baseballNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		BaseballNumber other = (BaseballNumber) obj;
		return baseballNumber ==  other.baseballNumber;
	}

}
