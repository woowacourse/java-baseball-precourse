package baseball.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	public static final int LIMITED_LENGTH = 3;
	public static final int MIN_NO = 1;
	public static final int MAX_NO = 9;

	private static final Computer computer = new Computer();

	private Balls balls;

	private Computer() {

	}

	public static Computer getInstance() {
		return computer;
	}

	public void init() {
		balls = Balls.from(makeRandom());
	}

	private String makeRandom() {
		Set<Integer> nos = new LinkedHashSet<>();
		while (nos.size() < LIMITED_LENGTH) {
			nos.add(Randoms.pickNumberInRange(MIN_NO, MAX_NO));
		}
		return nos.stream().map(Object::toString).reduce((a, b) -> a + b).get();
	}

	public Result matchBalls(String inputValue) {
		return balls.compare(Balls.from(inputValue));
	}
}
