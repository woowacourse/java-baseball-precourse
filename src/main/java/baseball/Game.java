package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

	public static void play() {
		List<Integer> answerNumber = generateAnswer();

		boolean running = true;
		do {
			System.out.print(Const.INPUT_MESSAGE);
			List<Integer> inputNumber = getInputNumber();

			Hint hint = new Hint(answerNumber, inputNumber);
			System.out.println(hint.getHintMessage());

			if (hint.isAllStrike())
				running = false;

		} while (running);
	}

	public static boolean askNewGameOrExit() {
		System.out.println(Const.NEW_GAME_OR_EXIT);
		String userSelect = Console.readLine();

		if (Const.SELECT_NEW_GAME.equals(userSelect))
			return true;

		if (Const.SELECT_EXIT.equals(userSelect))
			return false;

		throw new IllegalArgumentException();
	}

	private static List<Integer> generateAnswer() {
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < Const.ANSWER_SIZE; i++) {
			insertUniqueNumber(answer);
		}

		return answer;
	}

	private static void insertUniqueNumber(List<Integer> answer) {
		while (true) {
			int r = Randoms.pickNumberInRange(Const.MIN_ANSWER_VALUE, Const.MAX_ANSWER_VALUE);

			if (!answer.contains(r)) {
				answer.add(r);
				break;
			}
		}
	}

	private static boolean isCorrectInput(String inputText) {
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

	private static boolean isSingleDigit(String inputText, int index) {
		int n = Character.getNumericValue(inputText.charAt(index));
		return n <= Const.MAX_ANSWER_VALUE && n >= Const.MIN_ANSWER_VALUE;
	}

	private static boolean isDuplicateNumber(String inputText, int index) {
		String prevNums = inputText.substring(0, index);
		String nowNum = Character.toString(inputText.charAt(index));
		return prevNums.contains(nowNum);
	}

	private static List<Integer> getInputNumber() {
		List<Integer> result = new ArrayList<>();

		String inputNumber = Console.readLine();

		if (!isCorrectInput(inputNumber))
			throw new IllegalArgumentException();

		for (int i = 0; i < inputNumber.length(); i++)
			result.add(Character.getNumericValue(inputNumber.charAt(i)));

		return result;
	}
}
