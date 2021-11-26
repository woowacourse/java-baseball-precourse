package baseball.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	public static final int LIMITED_LENGTH = 3;
	public static final int MIN_NO = 1;
	public static final int MAX_NO = 9;
	private static final Computer com = new Computer();

	private Balls balls;

	private Computer() {

	}

	public static Computer getInstance() {
		return com;
	}

	//일급컬렉션 사용으로 유효값이 보장되므로 따로 로직 구현을 안해도 되서 좋았음
	public void init() {
		balls = Balls.from(makeRandom());
	}

	//set 자료구조를 사용해서 중복값 제외시킴
	//LinkedHashSet을 사용해서 입력된 순서대로 데이터를 관리할 수 있음 그래서 반복시 입력된 순서로 반복된다.
	//HashSet은 순서보장이 안됨.
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
