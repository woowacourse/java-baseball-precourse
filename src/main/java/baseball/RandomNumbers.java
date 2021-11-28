package baseball;

import static baseball.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RandomNumbers {
	private LinkedHashSet<Integer> numbers = new LinkedHashSet<>(MAX_BALL_SIZE);

	public RandomNumbers() {
		addNumbers();
	}

	private void addNumbers() {
		while (numbers.size() < MAX_BALL_SIZE) {
			numbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
		}
	}

	public List<Integer> getNumberList() {
		return new ArrayList<>(numbers);
	}
}
