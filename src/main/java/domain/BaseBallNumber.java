package domain;

import lombok.Getter;

@Getter
public class BaseBallNumber {

	private static final int MIN_NUM = 1;
	private static final int MAX_NUM = 9;

	private Integer value;

	private BaseBallNumber(Integer value) {
		this.value = value;
	}

	public static BaseBallNumber of(Integer value) {
		validate(value);
		return new BaseBallNumber(value);
	}

	private static void validate(Integer number) {
		if (number < MIN_NUM || number > MAX_NUM) {
			throw new IllegalArgumentException("잘못된 숫자입니다.");
		}
	}
}
