package baseball.model;

import java.util.List;

public interface BaseballFactory {
	char ZERO_CHAR = '0';
	int MIN_NUMBER = 1;
	int MAX_NUMBER = 9;
	int VALID_BASEBALL_NUMBER_SIZE = 3;
	int EXIST_NUMBER = 1;
	int START_INDEX = 0;

	List<Integer> createBaseballNumbers();
}
