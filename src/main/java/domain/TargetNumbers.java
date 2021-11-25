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

	public void compare(Numbers numbers) {
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

		System.out.println(ballCount + "볼 " + strikeCount + "스트라이크"); // TODO: Hint 클래스 정의하고 객체로 반환하도록 변경해야함
	}

}
