package baseball.utils;

import static baseball.constants.GameConfig.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import baseball.model.Answer;
import camp.nextstep.edu.missionutils.Randoms;

public class AnswerGenerator {
	public static Answer generate() {
		return createAnswer();
	}

	private static Answer createAnswer() {
		return new Answer(generateNonDuplicateNumbers());
	}

	private static List<Integer> generateNonDuplicateNumbers() {
		Set<Integer> randomNumbers = new LinkedHashSet<>();
		while (randomNumbers.size() < ANSWER_LENGTH) {
			int raandomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			randomNumbers.add(raandomNumber);
		}

		return new ArrayList<>(randomNumbers);
	}

}
