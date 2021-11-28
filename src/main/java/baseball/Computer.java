package baseball;

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
}
