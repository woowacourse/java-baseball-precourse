package baseball.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserInput {

	private final BaseballNumber baseballNumber;

	public UserInput(String gameUserInput) {
		this.baseballNumber = validate(gameUserInput);
	}

	public BaseballNumber validate(String gameUserInput) {
		try {
			return new BaseballNumber(
				new ArrayList<>(gameUserInput
					.chars()
					.mapToObj(Character::getNumericValue)
					.map(Number::new)
					.collect(Collectors.toList()))
			);
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public long sameNumberLocation(Computer computer) {
		return computer.sameNumberLocation(baseballNumber);
	}

	public long containsNumber(Computer computer) {
		return computer.containsNumber(baseballNumber);
	}

}
