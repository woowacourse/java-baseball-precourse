package utils;

import java.util.HashSet;

/**
 * 입력값을 검사하는 util
 * 기능 1. 입력값 중 중복된 값이 없는지 여부를 boolean으로 리턴
 * 기능 2. 입력값이 숫자로만 이루어졌는지 여부를 boolean으로 리턴
 * 기능 3. 입력값의 숫자들이 정해진 범위 내에 존재하는지 여부를 boolean으로 리턴
 * 기능 4. 위의 조건들을 모두 충족하는지 여부를 boolean으로 리턴
 */
public class InputCheckUtils {
	/** 입력값의 숫자의 범위를 한정하는 상수 */
	private static final Integer MAX_NUMBER_RANGE = 9;
	private static final Integer MIN_NUMBER_RANGE = 1;
	
	/** 입력값의 길이 체크를 위한 상수 */
	private static final Integer INPUT_LENGTH = 3;
	
	private InputCheckUtils() {
	}
	
	/** 입력값이 모든 조건들을 충족하는지 여부를 boolean으로 리턴 */
	public static boolean isVaild(String input) {
		if (!isNumber(input)) {
			return false;
		}
		if (!isRightRange(input)) {
			return false;
		}
		if (!isAllUniqueElement(input)) {
			return false;
		}
		if (!isRightLength(input)) {
			return false;
		}
		return true;
	}
	
	/** 입력값이 숫자로만 이루어졌는지 여부를 boolean으로 리턴 */
	public static boolean isNumber(String input) {
		if (isNull(input)) {
			return false;
		}
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/** 입력값의 숫자들이 정해진 범위 내에 존재하는지 여부를 boolean으로 리턴 */
	public static boolean isRightRange(String input) {
		for (char ch : input.toCharArray()) {
			int i = Character.getNumericValue(ch);
			if (i > MAX_NUMBER_RANGE || i < MIN_NUMBER_RANGE) {
				return false;
			}
		}
		return true;
	}
	
	/** 입력값 중 중복된 값이 없는지 여부를 boolean으로 리턴 */
	public static boolean isAllUniqueElement(String input) {
		HashSet<Character> inputChracterSet = new HashSet<Character>();
		for (char ch : input.toCharArray()) {
			inputChracterSet.add(ch);
		}
		if (inputChracterSet.size() != input.length()) {
			return false;
		}
		return true;
	}

	/** 입력값이 정해진 길이로 입력되었는지 여부를 boolean으로 리턴 */
	public static boolean isRightLength(String input) {
		if(input.length() != INPUT_LENGTH) {
			return false;
		}
		return true;
	}

	/** 입력값이 null인지 여부 boolean으로 리턴 */
	public static boolean isNull(String input) {
		if (input == null || input.isEmpty()) {
			return true;
		}
		return false;
	}
}
