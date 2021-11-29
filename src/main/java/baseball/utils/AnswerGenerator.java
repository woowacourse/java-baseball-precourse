package baseball.utils;

import static baseball.constants.GameConfig.*;

import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerGenerator {
	public static Set<Integer> generate() {
		Set<Integer> answer = new LinkedHashSet<>();
		while (answer.size() < NUMBER_LENGTH) {
			int raandomNumber = Randoms.pickNumberInRange(1, 9);
			answer.add(raandomNumber);
		}
		return answer;
	}

}
