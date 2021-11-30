package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

	public static final int SIZE = 3;

	private List<Ball> list;

	public Balls(List<Integer> list) {
		validateSize(list);
		validateDuplication(list);
		this.list = convertNumbersToBalls(list);
	}

	private static List<Ball> convertNumbersToBalls(List<Integer> numbers) {
		List<Ball> result = new ArrayList<>();
		for (int number : numbers) {
			result.add(new Ball(number));
		}
		return result;
	}

	private void validateDuplication(List<Integer> list) {
		Set<Integer> set = new HashSet<>(list);
		if (set.size() != list.size()) {
			throw new IllegalArgumentException();
		}
	}

	private void validateSize(List<Integer> list) {
		if (list.size() != SIZE) {
			throw new IllegalArgumentException();
		}
	}

	public List<Ball> getList() {
		return list;
	}

}