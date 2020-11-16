package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballNumberRepository {
	private static final int INITIAL_INDEX = 0;
	private static final int TOTAL_LENGTH = 3;
	private static final int MAX_NUMBER = 9;

	private final List<BaseballNumber> baseballNumbers = new ArrayList<>();

	public BaseballNumberRepository() {
		for (int i = 0; i <= MAX_NUMBER; i++) {
			baseballNumbers.add(new BaseballNumber(i));
		}
	}

	public List<BaseballNumber> randomNumbers() {
		shuffle();
		return baseballNumbers.subList(INITIAL_INDEX, TOTAL_LENGTH);
	}

	private void shuffle() {
		Collections.shuffle(baseballNumbers);
	}
}
