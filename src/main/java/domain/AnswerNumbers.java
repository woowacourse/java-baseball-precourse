package domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerNumbers extends BaseballNumbers {
	public AnswerNumbers() {
		this.baseballNumbers = generateRandomNumbers();
	}

	private List<BaseballNumber> generateRandomNumbers() {
		List<BaseballNumber> baseballNumbers = new ArrayList<BaseballNumber>();
		while (baseballNumbers.size() < NUMBERS_SIZE) {
			BaseballNumber nextBaseballNumber = new BaseballNumber(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
			if (!baseballNumbers.contains(nextBaseballNumber)) {
				baseballNumbers.add(nextBaseballNumber);
			}
		}
		return baseballNumbers;
	}

	public CompareResult compareNumbers(BaseballNumbers baseballNumbers) {
		int ballCount = 0;
		int strikeCount = 0;

		for (int i = 0; i < NUMBERS_SIZE; i++) {
			BaseballNumber baseballNumber = this.baseballNumbers.get(i);
			if (baseballNumbers.isRightPosition(baseballNumber, i)) {
				strikeCount++;
			} else if (baseballNumbers.hasNumber(baseballNumber)) {
				ballCount++;
			}
		}
		return new CompareResult(ballCount, strikeCount);
	}
}
