package baseball;

import java.util.stream.IntStream;

public class BaseballNumberReferee {
	private final BaseballNumberValidator validator;

	public BaseballNumberReferee(BaseballNumberValidator validator) {
		this.validator = validator;
	}

	public JudgeResult judge(String input, String number) {
		if(!validator.validate(input)) {
			throw new IllegalArgumentException(String.format("%s는 잘못된 입력값입니다.", input));
		}

		return new JudgeResult(numberOfStrike(input, number));
	}

	private int numberOfStrike(String input, String number) {
		return (int) IntStream.range(0, input.length())
			.filter(i -> isEqualCharacter(input.charAt(i), number.charAt(i)))
			.count();
	}

	private boolean isEqualCharacter(char inputChar, char numberChar) {
		return inputChar == numberChar;
	}
}
