package baseball.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.domain.AnswerNumber;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
	public List<Integer> generate() {
		Set<Integer> randomNumberSet = new HashSet<>();
		while (randomNumberSet.size() < AnswerNumber.ANSWER_LENGTH) {
			randomNumberSet.add(
				Randoms.pickNumberInRange(AnswerNumber.ANSWER_MIN_VALUE, AnswerNumber.ANSWER_MAX_VALUE));
		}
		return new ArrayList<>(randomNumberSet);
	}
}
