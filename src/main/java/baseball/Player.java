package baseball;

import static camp.nextstep.edu.missionutils.Console.*;
import static util.GameConstant.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Player {
	public List<Integer> getPlayerNumber() throws IllegalArgumentException {
		System.out.print(INPUT_MESSAGE);
		String inputNumber = readLine();
		return toIntegerList(inputNumber);
	}

	public int getRestartOrEndNumber() throws IllegalArgumentException {
		String inputNumber = readLine();
		validateNumberRange(RESTART_OR_END_NUMBER_REGEX, inputNumber);
		return Integer.parseInt(inputNumber);
	}

	private List<Integer> toIntegerList(String inputNumber) throws IllegalArgumentException {
		validateInputNumber(inputNumber);
		List<String> numbers = Arrays.asList(inputNumber.split(""));
		return numbers.stream()
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private void validateInputNumber(String inputNumber) throws IllegalArgumentException {
		validateNumberRange(PLAYER_NUMBER_REGEX, inputNumber);
		validateNumberDuplication(inputNumber);
	}

	private void validateNumberRange(String regex, String inputNumber) {
		if (!Pattern.matches(regex, inputNumber)) {
			throw new IllegalArgumentException();
		}
	}

	private void validateNumberDuplication(String inputNumber) {
		HashSet<String> numbers = new HashSet<>(
			Arrays.asList(inputNumber.split(""))
		);
		if (numbers.size() != NUMBER_LENGTH) {
			throw new IllegalArgumentException();
		}
	}
}
