package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
	public List<Integer> getPlayerInputNum() {
		System.out.print(Constants.ENTER_THREE_DIGIT);
		String playerInput = Console.readLine();
		validateLength(playerInput);
		validateDupNumber(playerInput);
		return Arrays.stream(playerInput.split("")).map(Integer::parseInt).collect(Collectors.toList());
	}

	private void validateLength(String playerInput) {
		if (playerInput.length() != Constants.DIGIT_LENGTH) {
			throw new IllegalArgumentException(Constants.ERROR_VALIDATE_LENGTH);
		}
	}

	private void validateDupNumber(String playerInput) {
		if (playerInput.charAt(0) == playerInput.charAt(1)) {
			throw new IllegalArgumentException(Constants.ERROR_DUPLICATE_NUM);
		} else if (playerInput.charAt(0) == playerInput.charAt(2)) {
			throw new IllegalArgumentException(Constants.ERROR_DUPLICATE_NUM);
		} else if (playerInput.charAt(1) == playerInput.charAt(2)) {
			throw new IllegalArgumentException(Constants.ERROR_DUPLICATE_NUM);
		}
	}
}
