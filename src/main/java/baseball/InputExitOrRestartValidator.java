package baseball;

public class InputExitOrRestartValidator {

	private static final int EXIT_OR_RESTART_LENGTH = 1;
	private static final String EXIT_NUMBER = "1";
	private static final String RESTART_NUMBER = "2";
	private String inputExitOrRestart;

	InputExitOrRestartValidator(String inputExitOrRestart) {
		this.inputExitOrRestart = inputExitOrRestart;

		checkExitOrRestartLength();
		checkExitOrRestartRange();
	}

	public void checkExitOrRestartLength() {
		if (inputExitOrRestart.length() != 1) {
			throw new IllegalArgumentException("1자리 숫자를 입력해주세요.");
		}
	}

	public void checkExitOrRestartRange() {
		if (!(inputExitOrRestart.equals(EXIT_NUMBER) || inputExitOrRestart.equals(RESTART_NUMBER))) {
			throw new IllegalArgumentException("숫자 1 또는 2를 입력해주세요.");
		}
	}
}
