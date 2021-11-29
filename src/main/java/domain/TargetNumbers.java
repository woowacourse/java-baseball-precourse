package domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class TargetNumbers extends Numbers {
	public TargetNumbers() {
		this.numbers = generateRandomNumbers();
	}

	private List<Number> generateRandomNumbers() {
		List<Number> generatedNumbers = new ArrayList<Number>();

		while (generatedNumbers.size() < NUMBERS_SIZE) {
			Number nextNumber = new Number(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
			if (!generatedNumbers.contains(nextNumber)) {
				generatedNumbers.add(nextNumber);
			}
		}

		return generatedNumbers;
	}

	public PredictionResult compareTo(Numbers numbers) {
		int ballCount = 0;
		int strikeCount = 0;

		for (int i = 0; i < NUMBERS_SIZE; i++) {
			Number currentNumber = this.numbers.get(i);

			if (numbers.isSamePosition(currentNumber, i)) {
				strikeCount++;
			} else if (numbers.hasNumber(currentNumber)) {
				ballCount++;
			}
		}

		return new PredictionResult(ballCount, strikeCount);
	}
}
