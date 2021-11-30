package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {
	private List<Integer> inputNumber;

	public List<Integer> getInputNumber() {
		return this.inputNumber;
	}

	public void readInputNumber() {
		List<Integer> result = new ArrayList<>();

		String inputNumber = Console.readLine();

		if (!isCorrectInput(inputNumber))
			throw new IllegalArgumentException();

		for (int i = 0; i < inputNumber.length(); i++)
			result.add(Character.getNumericValue(inputNumber.charAt(i)));

		this.inputNumber = result;
	}

	private boolean isCorrectInput(String inputText) {
		if (inputText.length() != Const.ANSWER_SIZE) // 길이가 3이 아님
			return false;

		for (int i = 0; i < inputText.length(); i++) {
			if (!isSingleDigit(inputText, i)) // 1~9 숫자가 아님
				return false;

			if (isDuplicateNumber(inputText, i)) // 숫자 중복
				return false;
		}

		return true;
	}

	private boolean isSingleDigit(String inputText, int index) {
		int n = Character.getNumericValue(inputText.charAt(index));
		return n <= Const.MAX_ANSWER_VALUE && n >= Const.MIN_ANSWER_VALUE;
	}

	private boolean isDuplicateNumber(String inputText, int index) {
		String prevNums = inputText.substring(0, index);
		String nowNum = Character.toString(inputText.charAt(index));
		return prevNums.contains(nowNum);
	}
}
