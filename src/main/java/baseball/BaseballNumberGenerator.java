package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballNumberGenerator {
	private final BaseballNumberValidator validator;

	public BaseballNumberGenerator(BaseballNumberValidator validator) {
		this.validator = validator;
	}

	public int generate() {
		int number = pickNumberInRange(123, 987);

		if (validator.validate(String.valueOf(number))) {
			return number;
		}

		return generate();
	}
}
