package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Refree {
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

	private void checkDuplicated(List<Integer> integerNumbers) {
		if (isDuplicated(integerNumbers)) {
			throw new IllegalArgumentException("같은 수를 2번이상 입력하였습니다.");
		}
	}

	private boolean isDuplicated(List<Integer> integerNumbers) {
		return integerNumbers.stream().distinct().count() != integerNumbers.size();
	}

	private List<Integer> checkFormatAndConvert(String stringNumbers) {
		List<Integer> integerNumbers = new ArrayList<>();
		for (String stringNumber : stringNumbers.split("")) {
			try {
				integerNumbers.add(Integer.valueOf(stringNumber));
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("숫자를 입력하세요.");
			}
		}
		return integerNumbers;
	}

	private void checkLength(String stringNumbers) {
		if (!isValidLength(stringNumbers)) {
			throw new IllegalArgumentException("숫자 3개를 입력해주세요.");
		}
	}

	private boolean isValidLength(String stringNumbers) {
		return stringNumbers.length() == 3;
	}

	private void checkRange(List<Integer> integerNumbers) {
		for (Integer number : integerNumbers) {
			if (!(1 <= number && number <= 9)) {
				throw new IllegalArgumentException("1~9사이의 값을 입력해주세요.");
			}
		}

	}

	public String compare(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		return "";
	}

	public Integer countSameNumber(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		return 0;
	}

	public Integer countStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		return 0;
	}
}
