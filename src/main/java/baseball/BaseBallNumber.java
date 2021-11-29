package baseball;

import static baseball.Constants.*;

import util.InputValidationUtils;

public class BaseBallNumber {
	private final String ballNumber;

	public BaseBallNumber(String ballNumber) {
		if (!InputValidationUtils.isCheckValid(ballNumber)) {
			throw new IllegalArgumentException("1~9까지 서로 다른 숫자 3자리만 입력 가능합니다.");
		}
		this.ballNumber = ballNumber;
	}

	public String getBallNumber() {
		return ballNumber;
	}

}
