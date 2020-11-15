package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BaseballNumbers {
	private static final String VALID_NUMBER_MESSAGE = "숫자(정수)만 입력 가능합니다.";
	private static final String OUT_OF_NUMBER_LENGTH_MESSAGE = "세자릿 수까지 입력해주세요.";
	private static final int TOTAL_NUMBER_LENGTH = 3;

	private final List<BaseballNumber> baseballNumbers;

	public BaseballNumbers(String baseballNumbers) {
		validateBaseballNumbers(baseballNumbers);
		this.baseballNumbers = convertBaseballNumbersType(baseballNumbers);
	}

	private List<BaseballNumber> convertBaseballNumbersType(String baseballNumbers) {
		List<String> baseballNumbersList = Arrays.asList(baseballNumbers.split(""));
		List<BaseballNumber> convertBaseballNumbers = new ArrayList<>();
		for (String baseballNumber : baseballNumbersList) {
			convertBaseballNumbers.add(new BaseballNumber(Integer.parseInt(baseballNumber)));
		}
		return convertBaseballNumbers;
	}

	private void validateBaseballNumbers(String baseballNumbers) {
		Objects.requireNonNull(baseballNumbers);
		validateNumber(baseballNumbers);
		validateLength(baseballNumbers);
	}

	private void validateNumber(String baseballNumbers) {
		if (!isNumber(baseballNumbers)) {
			throw new IllegalArgumentException(VALID_NUMBER_MESSAGE);
		}

	}

	private void validateLength(String baseballNumbers) {
		if (baseballNumbers.length() != TOTAL_NUMBER_LENGTH) {
			throw new IllegalArgumentException(OUT_OF_NUMBER_LENGTH_MESSAGE);
		}
	}

	private boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
