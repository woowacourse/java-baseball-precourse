package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
	public List<Integer> getPlayerInputNum() {
		System.out.print("숫자를 입력하세요: ");
		String playerInput = Console.readLine();
		validateLength(playerInput);
		validateDupNumber(playerInput);
		return Arrays.stream(playerInput.split("")).map(Integer::parseInt).collect(Collectors.toList());
	}

	private void validateLength(String playerInput) {
		if (playerInput.length() != 3) {
			throw new IllegalArgumentException("length of player input must be 3");
		}
	}

	private void validateDupNumber(String playerInput) {
		if (playerInput.charAt(0) == playerInput.charAt(1)) {
			throw new IllegalArgumentException("player input must be different each other");
		} else if (playerInput.charAt(0) == playerInput.charAt(2)) {
			throw new IllegalArgumentException("player input must be different each other");
		} else if (playerInput.charAt(1) == playerInput.charAt(2)) {
			throw new IllegalArgumentException("player input must be different each other");
		}
	}
}
