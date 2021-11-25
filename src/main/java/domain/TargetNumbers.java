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

	public Hint compare(Numbers numbers) {
		int ballCount = 0, strikeCount = 0;

		for (int i = 0; i < NUMBERS_SIZE; i++) {
			int currentNumber = this.numbers.get(i).getNumber();
			int numberIndex = numbers.find(currentNumber);

			if (numberIndex < 0)
				continue;

			if (numberIndex == i) {
				strikeCount++;
				continue;
			}

			ballCount++;
		}

		return new Hint(ballCount, strikeCount);
	}

}
