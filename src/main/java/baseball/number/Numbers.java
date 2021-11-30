package baseball.number;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import baseball.type.Hint;
import camp.nextstep.edu.missionutils.Randoms;

public class Numbers {
	private static final int DIGIT = 3;
	private final List<Number> numbers;

	private Numbers(Set<Number> numberSet) {
		validateDuplicate(numberSet);
		numbers = new ArrayList<>(numberSet);
	}

	public static Numbers create() {
		Set<Number> numbers = new LinkedHashSet<>();
		while (numbers.size() < DIGIT) {
			int num = Randoms.pickNumberInRange(Number.MIN, Number.MAX);
			Number number = Number.valueOf(num);
			numbers.add(number);
		}
		return new Numbers(numbers);
	}

	public static Numbers from(String value) {
		validateStringLength(value);
		Set<Number> numbers = new LinkedHashSet<>();
		char[] numberChars = value.toCharArray();
		for (char numberChar : numberChars) {
			Number number = Number.valueOf(numberChar);
			numbers.add(number);
		}
		return new Numbers(numbers);
	}

	private static void validateStringLength(String value) {
		if (value.length() != DIGIT) {
			throw new IllegalArgumentException("문자열의 길이가 3보다 크거나 작을 수 없습니다.");
		}
	}

	private static void validateDuplicate(Set<Number> numbers) {
		if (numbers.size() != DIGIT) {
			throw new IllegalArgumentException("중복된 수가 존재합니다.");
		}
	}

	public Hint getHint(Number number, int index) {
		int findIdx = numbers.indexOf(number);
		if (findIdx == index) {
			return Hint.STRIKE;
		} else if (findIdx == -1) {
			return Hint.NOTHING;
		}
		return Hint.BALL;
	}

	public List<Number> getNumbers() {
		return new ArrayList<>(numbers);
	}
}
