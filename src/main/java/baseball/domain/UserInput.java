package baseball.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserInput {

	private static final String USER_INPUT_ERROR = "1에서 9까지의 임의의 수 3개의 숫자를 입력해주세요.";
	private static final int SIZE = 3;
	private BaseballNumber baseballNumber;

	public UserInput(String gameUserInput) {

		if (gameUserInput.length() != SIZE) {
			throw new IllegalArgumentException(USER_INPUT_ERROR);
		}

		try {
			this.baseballNumber = new BaseballNumber(
				new ArrayList<>(gameUserInput
					.chars()
					.mapToObj(Character::getNumericValue)
					.map(Number::new)
					.collect(Collectors.toList()))
			);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(USER_INPUT_ERROR);
		}

	}
}
