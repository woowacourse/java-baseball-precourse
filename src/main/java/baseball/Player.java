package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	public int[] getNumberFromPlayer() {
		String tempInput = Console.readLine();
		int[] playerNumber = new int[tempInput.length()];

		for (int i = 0; i < tempInput.length(); i++) {
			playerNumber[i] = tempInput.charAt(i) - '0';
		}
		checkException(playerNumber);
		return playerNumber;
	}

	public void checkException(int[] playerNumber) {
		if (playerNumber.length != Constant.NUMBER_LENGTH) {
			throw new IllegalArgumentException();
		}
		if (isStartWithZero(playerNumber)) {
			throw new IllegalArgumentException();
		}
		if (isDuplicate(playerNumber)) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isStartWithZero(int[] number) {
		if (number[0] == 0) {
			return true;
		}
		return false;
	}

	public boolean isDuplicate(int[] number) {
		ArrayList<Integer> integerArray = (ArrayList<Integer>)Arrays.stream(number)
			.boxed()
			.collect(Collectors.toList());

		LinkedHashSet<Integer> linkedHashSet =
			new LinkedHashSet<>(integerArray);

		if (number.length != linkedHashSet.size()) {
			return true;
		}
		return false;
	}
}
