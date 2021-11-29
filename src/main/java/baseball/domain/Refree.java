package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Refree {

	public static final String INVALID_INPUT_DUPLICATED_MESSAGE = "같은 수를 2번이상 입력하였습니다.";
	public static final String INVALID_INPUT_FORMAT_MESSAGE = "숫자를 입력하세요.";
	public static final String INVALID_INPUT_LENGTH_MESSAGE = "숫자 3개를 입력해주세요.";
	public static final String INVALID_INPUT_RANGE_MESSAGE = "1~9사이의 값을 입력해주세요.";
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 9;
	public static final String EMPTY_STRING = "";

	public List<Integer> askNumbers(String stringNumbers) {
		return checkValidationAndConvertType(stringNumbers);
	}

	public List<Integer> checkValidationAndConvertType(String stringNumbers) {
		checkLength(stringNumbers);
		List<Integer> integerNumbers = checkFormatAndConvert(stringNumbers);
		checkRange(integerNumbers);
		checkDuplicated(integerNumbers);

		return integerNumbers;

	}

	private List<Integer> checkFormatAndConvert(String stringNumbers) {
		List<Integer> integerNumbers = new ArrayList<>();
		for (String stringNumber : stringNumbers.split(EMPTY_STRING)) {
			try {
				integerNumbers.add(Integer.valueOf(stringNumber));
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(INVALID_INPUT_FORMAT_MESSAGE);
			}
		}
		return integerNumbers;
	}

	private void checkLength(String stringNumbers) {
		if (!isValidLength(stringNumbers)) {
			throw new IllegalArgumentException(INVALID_INPUT_LENGTH_MESSAGE);
		}
	}

	private boolean isValidLength(String stringNumbers) {
		return stringNumbers.length() == 3;
	}

	private void checkRange(List<Integer> integerNumbers) {
		for (Integer number : integerNumbers) {
			if (!isValidRange(number)) {
				throw new IllegalArgumentException(INVALID_INPUT_RANGE_MESSAGE);
			}
		}

	}

	private boolean isValidRange(Integer number) {
		return MIN_NUMBER <= number && number <= MAX_NUMBER;
	}

	private void checkDuplicated(List<Integer> integerNumbers) {
		if (isDuplicated(integerNumbers)) {
			throw new IllegalArgumentException(INVALID_INPUT_DUPLICATED_MESSAGE);
		}
	}

	private boolean isDuplicated(List<Integer> integerNumbers) {
		return integerNumbers.stream().distinct().count() != integerNumbers.size();
	}

	public String compare(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		StringBuffer result = new StringBuffer();
		int sameNumberCount = countSameNumber(computerNumbers, playerNumbers);
		if (sameNumberCount == 0) {
			return result.append("낫싱").toString();
		}
		Integer strikeCount = countStrike(computerNumbers, playerNumbers);
		Integer ballCount = countBall(sameNumberCount, strikeCount);
		if (ballCount > 0) {
			result.append(ballCount);
			result.append("볼");
			result.append(" ");
		}
		if (strikeCount > 0) {
			result.append(strikeCount);
			result.append("스크라이크");
		}

		return result.toString();
	}

	public Integer countSameNumber(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		int sameNumberCount = 0;
		for (Integer playerNumber : playerNumbers) {
			if (computerNumbers.contains(playerNumber)) {
				sameNumberCount++;
			}
		}
		return sameNumberCount;
	}

	public Integer countStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		int strikeCount = 0;
		for (int index = 0; index < playerNumbers.size(); index++) {
			if (computerNumbers.get(index) == playerNumbers.get(index))
				strikeCount++;
		}
		return strikeCount;
	}

	private int countBall(int sameNumberCount, Integer strikeCount) {
		return sameNumberCount - strikeCount;
	}

	public String askRestart(String input) {
		checkRestartInputLength(input);
		checkRestartInputRange(input);
		return input;
	}

	private void checkRestartInputLength(String input) {
		if (!isValidRestartInputLength(input)) {
			throw new IllegalArgumentException("1개만 입력해주세요");
		}
	}

	private boolean isValidRestartInputLength(String input) {
		return input.length() == 1;
	}

	private void checkRestartInputRange(String input) {
		if (!isValidRestartInputRange(input)) {
			throw new IllegalArgumentException("1 혹은 2를 입력해주세요");
		}
	}

	private boolean isValidRestartInputRange(String input) {
		return input.equals("1") || input.equals("2");
	}
}
