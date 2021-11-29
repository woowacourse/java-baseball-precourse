package baseball.domain.ball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import baseball.AppConfig;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBallSetFactory {

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
		NumberBallSetInputValidator.validateAll(input);
		return input.chars().mapToObj(x -> Character.digit(x, AppConfig.RADIX)).collect(Collectors.toList());
	}
}
