package domain;

import lombok.Getter;

@Getter
public class BaseBallNumber {

	private final int MIN_NUM = 1;
	private final int MAX_NUM = 9;

	private Integer value;

	BaseBallNumber(Integer value) {
		validate(value);
		this.value = value;
	}

	private void validate(Integer number) {
		if (number < MIN_NUM || number > MAX_NUM) {
			throw new IllegalArgumentException("잘못된 숫자입니다.");
		}
	}
}
