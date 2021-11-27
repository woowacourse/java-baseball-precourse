package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.type.ExceptionType;
import baseball.type.NumberRangeType;
import camp.nextstep.edu.missionutils.Console;

public class Player {

	private static List<Integer> playerNumbers;

	public Player() {
		playerNumbers = new ArrayList<>(NumberRangeType.ANSWER_SIZE.getNumberRange());
	}

	public static List<Integer> getPlayerNumbers() {
		return playerNumbers;
	}

	public void generatePlayerNumber() {
		String enterPlayerNumber = enterInput();
		validatePlayerNumber(enterPlayerNumber);
		setPlayerNumber(enterPlayerNumber);
	}

	public String enterInput() {
		return Console.readLine();
	}

	private void setPlayerNumber(String enterPlayerNumber) {
		for (char number : enterPlayerNumber.toCharArray()) {
			playerNumbers.add(number - '0');
		}
	}

	private void validatePlayerNumber(String enterPlayerNumber) {
		validatePlayerNumberLength(enterPlayerNumber.length());
		validatePlayerNumberType(enterPlayerNumber);
		validatePlayerNumberDuplicate(enterPlayerNumber);
	}

	private void validatePlayerNumberType(String enterPlayerNumber) {
		for (char number : enterPlayerNumber.toCharArray()) {
			if (number < NumberRangeType.MIN_NUMBER_ASCII.getNumberRange()
				|| number > NumberRangeType.MAX_NUMBER_ASCII.getNumberRange()) {
				throw new IllegalArgumentException(ExceptionType.WRONG_TYPE_INPUT.getMessage());
			}
		}
	}

	private void validatePlayerNumberDuplicate(String enterPlayerNumber) {
		Set<Character> checkList = new HashSet<>();
		for (char number : enterPlayerNumber.toCharArray()) {
			if (checkList.contains(number)) {
				throw new IllegalArgumentException(ExceptionType.DUPLICATE.getMessage());
			}
			checkList.add(number);
		}
	}

	private void validatePlayerNumberLength(int enterPlayerNumberLength) {
		if (enterPlayerNumberLength != NumberRangeType.ANSWER_SIZE.getNumberRange()) {
			throw new IllegalArgumentException(ExceptionType.OUT_OF_LENGTH.getMessage());
		}
	}
}
