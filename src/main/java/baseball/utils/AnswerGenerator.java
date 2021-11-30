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
		return new Answer(generateNonDuplicateNumbers());
	}
	
	private static List<Integer> generateNonDuplicateNumbers() {
		Set<Integer> randomNumbers = new LinkedHashSet<>();
		while (randomNumbers.size() < ANSWER_LENGTH) {
			int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			randomNumbers.add(randomNumber);
		}

		return new ArrayList<>(randomNumbers);
	}

}
