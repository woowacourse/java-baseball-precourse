package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.BaseballGame.TARGET_SIZE;

public class Computer {
	public static final int RESTART_OPTION_SIZE = 1;
	public static final int RESTART_YES = 1;
	public static final int RESTART_NO = 2;

	private void validateGuessInput(String input) {
		if (!InputValidator.isRightGuessInput(input)) {
			throw new IllegalArgumentException();
		}
	}

	private void validateRestartInput(String input) {
		if (!InputValidator.isRightGuessInput(input)) {
			throw new IllegalArgumentException();
		}
	}

	public List<Integer> parseGuessInput(String guessInput) {
		List<Integer> guessNums = new ArrayList<>();
		for (int i = 0; i < TARGET_SIZE; i++) {
			guessNums.add(new Integer(guessInput.substring(i, i+1)));
		}
		return guessNums;
	}
}
