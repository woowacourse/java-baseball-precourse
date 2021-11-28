package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.BaseballGame.TARGET_SIZE;

public class Computer {
	public static final int RESTART_OPTION_SIZE = 1;
	public static final int RESTART_YES = 1;
	public static final int RESTART_NO = 2;

	private BaseballGame baseballGame = new BaseballGame();

	public void startNewGame() {
		baseballGame.setNewTarget();

		while (!baseballGame.isGuessEqualTarget()) {
			String playerGuessInput = Player.getGuessInput();
			validateGuessInput(playerGuessInput);
			List<Integer> guessNums = parseGuessInput(playerGuessInput);
			baseballGame.judgeAndShowHint(guessNums);
		}

		notifyGameEnd();
	}

	private void validateGuessInput(String input) {
		if (!InputValidator.isRightGuessInput(input)) {
			throw new IllegalArgumentException();
		}
	}

	private void validateRestartInput(String input) {
		if (!InputValidator.isRightRestartInput(input)) {
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

	private void notifyGameEnd() {
		System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", TARGET_SIZE);
	}
}
