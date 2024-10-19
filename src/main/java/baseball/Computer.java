package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private List<Integer> numbers;

	public Computer() {
		generateNumbers();
	}

	private void generateNumbers() {
		numbers = new ArrayList<>();
		while (numbers.size() < 3) {
			int num = Randoms.pickNumberInRange(1, 9);
			if(!numbers.contains(num)) {
				numbers.add(num);
			}
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
