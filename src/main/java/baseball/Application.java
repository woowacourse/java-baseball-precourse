package baseball;

import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	private static final int NUMBER_LENGTH = 3;

	public static void main(String[] args) {
		Set<Integer> answer = new LinkedHashSet<>();
		while (answer.size() < NUMBER_LENGTH) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			answer.add(randomNumber);
		}
	}
}
