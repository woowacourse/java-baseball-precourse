package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballNumberRepository {
	private static final int INITIAL_INDEX = 0;
	private static final int TOTAL_LENGTH = 3;
	
	private final List<BaseballNumber> baseballNumbers = new ArrayList<>(); 
	
	public BaseballNumberRepository() {
		baseballNumbers.add(new BaseballNumber(1));
		baseballNumbers.add(new BaseballNumber(2));
		baseballNumbers.add(new BaseballNumber(3));
		baseballNumbers.add(new BaseballNumber(4));
		baseballNumbers.add(new BaseballNumber(5));
		baseballNumbers.add(new BaseballNumber(6));
		baseballNumbers.add(new BaseballNumber(7));
		baseballNumbers.add(new BaseballNumber(8));
		baseballNumbers.add(new BaseballNumber(9));
	}
	
	public List<BaseballNumber> randomNumbers() {
		shuffle();
		return baseballNumbers.subList(INITIAL_INDEX, TOTAL_LENGTH);
	}
	
	private void shuffle() {
		Collections.shuffle(baseballNumbers);
	}
}
