package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static java.util.stream.Collectors.*;

import java.util.stream.IntStream;

public class BaseballNumberGenerator {
	private final BaseballNumberValidator validator;

	public BaseballNumberGenerator(BaseballNumberValidator validator) {
		this.validator = validator;
	}

	public String generate() {
		String number = createRandomNumber();

		if (validator.validate(number)) {
			return number;
		}

		return generate();
	}

	private String createRandomNumber() {
		return IntStream
				.range(0, 3)
				.map(i -> pickNumberInRange(1, 9))
				.mapToObj(String::valueOf)
				.collect(joining());
	}
}
