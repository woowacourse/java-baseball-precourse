package baseball;

import java.util.stream.IntStream;

public class BaseballNumberReferee {
	private final BaseballNumberValidator validator;

	public BaseballNumberReferee(BaseballNumberValidator validator) {
		this.validator = validator;
	}

	public JudgeResult judge(String input, String number) {
		if (!validator.validate(input)) {
			throw new IllegalArgumentException(String.format("%s는 잘못된 입력값입니다.", input));
		}

		return JudgeResult.of(numberOfStrike(input, number), numberOfBall(input, number));
	}

	private int numberOfStrike(String input, String number) {
		return (int) IntStream.range(0, input.length())
				.filter(i -> isEqualCharacter(input.charAt(i), number.charAt(i)))
				.count();
	}

	private boolean isEqualCharacter(char inputChar, char numberChar) {
		return inputChar == numberChar;
	}

	private int numberOfBall(String input, String number) {
		return (int) IntStream
				.range(0, input.length())
				.filter(i -> isBall(i, input, number))
				.count();
	}

	private boolean isBall(int indexOfInput, String input, String number) {
		return IntStream
				.range(0, number.length())
				.filter(indexOfNumber -> isNotSameIndex(indexOfInput, indexOfNumber))
				.anyMatch(indexOfNumber -> isEqualCharacter(input.charAt(indexOfInput), number.charAt(indexOfNumber)));
	}

	private boolean isNotSameIndex(int index1, int index2) {
		return index1 != index2;
	}
}
