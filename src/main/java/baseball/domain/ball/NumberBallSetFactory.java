package baseball.domain.ball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import baseball.AppConfig;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBallSetFactory {
	private static final String ERROR_NON_DIGIT = "숫자가 아닌 값이 들어있습니다.";
	private static final String ERROR_LENGTH = String.format("길이는 %d 이어야 합니다", NumberBallSet.NUMBER_COUNT);
	private static final String ERROR_DUPLICATION = "중복된 숫자가 있습니다.";

	private NumberBallSetFactory() {
	}

	protected static List<Integer> generateNumbersFromRandom() {
		Set<Integer> set = new LinkedHashSet<>();
		while (set.size() < NumberBallSet.NUMBER_COUNT) {
			set.add(Randoms.pickNumberInRange(NumberBall.MIN, NumberBall.MAX));
		}
		return new ArrayList<>(set);
	}

	protected static List<Integer> generateNumbersFromInput(String input) {
		validateAll(input);
		return input.chars().mapToObj(x -> Character.digit(x, AppConfig.RADIX)).collect(Collectors.toList());
	}

	private static void validateAll(String input) {
		validateLength(input);
		validateDigit(input);
		validateNonDuplication(input);
	}

	private static void validateLength(String input) {
		if (input.length() != NumberBallSet.NUMBER_COUNT) {
			throw new IllegalArgumentException(ERROR_LENGTH);
		}
	}

	private static void validateDigit(String input) {
		if (!input.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException(ERROR_NON_DIGIT);
		}
	}

	private static void validateNonDuplication(String input) {
		if (input.chars().distinct().reduce(0, (x, y) -> x + 1) != NumberBallSet.NUMBER_COUNT) {
			throw new IllegalArgumentException(ERROR_DUPLICATION);
		}
	}
}
