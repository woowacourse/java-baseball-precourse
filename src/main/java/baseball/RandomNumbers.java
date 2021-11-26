package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RandomNumbers {
	private LinkedHashSet<Integer> numbers = new LinkedHashSet<>(3);

	public RandomNumbers() {
		addNumbers();
	}

	private void addNumbers() {
		while (numbers.size() < 3) {
			numbers.add(Randoms.pickNumberInRange(1, 9));
		}
	}

	public List<Integer> getNumberList() {
		return new ArrayList<>(numbers);
	}
}
