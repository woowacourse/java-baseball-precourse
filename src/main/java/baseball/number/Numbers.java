package baseball.number;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Numbers {
	private static final int DIGIT = 3;
	private final List<Number> numbers;

	private Numbers(Set<Number> numberSet) {
		validateDuplicate(numberSet);
		numbers = new ArrayList<>(numberSet);
	}

	public static Numbers create(){
		Set<Number> numbers = new LinkedHashSet<>();
		while(numbers.size()<DIGIT) {
			int num = Randoms.pickNumberInRange(1, 9);
			Number number = Number.valueOf(num);
			numbers.add(number);
		}
		return new Numbers(numbers);
	}

	public static Numbers from(String value){
		validateStringLength(value);
		Set<Number> numbers = new LinkedHashSet<>();
		char[] numberChars = value.toCharArray();
		for (char numberChar : numberChars) {
			Number number = Number.valueOf(numberChar);
			numbers.add(number);
		}
		return new Numbers(numbers);
	}

	private static void validateStringLength(String value){
		if(value.length()!=DIGIT){
			throw new IllegalArgumentException("문자열의 길이가 3보다 크거나 작을 수 없습니다.");
		}
	}

	private static void validateDuplicate(Set<Number> numbers){
		if(numbers.size()!=DIGIT){
			throw new IllegalArgumentException("중복된 수가 존재합니다.");
		}
	}
}
