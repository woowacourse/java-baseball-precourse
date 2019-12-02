package src.main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Computer {

	private static final int DIGITS = 3;
	private static final int MAX = 9;
	private static final int MIN = 1;

	List<Integer> comNums;

	void createNumbers() {
		comNums = new ArrayList<>();
		while (comNums.size() < DIGITS) {
			int rand = (int) ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
			if (!comNums.contains(rand)) {
				comNums.add(rand);
			}
		}
	}
}
