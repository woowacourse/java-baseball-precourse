package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private List<Integer> randomGeneratedNumber;

	public void generateRandomNumber() {
		randomGeneratedNumber = new ArrayList<>();
		while (this.randomGeneratedNumber.size() < 3) {
			int digit = Randoms.pickNumberInRange(1, 9);
			if (!this.randomGeneratedNumber.contains(digit)) {
				this.randomGeneratedNumber.add(digit);
			}
		}
	}
}
