package baseball.domain;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int NUMBER_LENGTH = 3;
	private Integer[] answer;

	public Computer() {
		answer = new Integer[NUMBER_LENGTH];
	}

	public void generateAnswer() {
		Set<Integer> tmpSet = new HashSet<>();

		while (tmpSet.size() != NUMBER_LENGTH) {
			tmpSet.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
		}

		int index = 0;
		for (Integer integer : tmpSet) {
			answer[index] = integer;
			index++;
		}

	}

	public Integer[] getAnswer() {
		return answer;
	}
}
