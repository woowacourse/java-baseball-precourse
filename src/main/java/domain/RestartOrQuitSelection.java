package domain;

public class RestartOrQuitSelection {
	private static final String RESTART_INPUT = "1";
	private static final String QUIT_INPUT = "2";

	private final String selection;

	public RestartOrQuitSelection(String selection) {
		validateSelection(selection);
		this.selection = selection;
	}

	private void validateSelection(String selection) {
		if (selection.equals(RESTART_INPUT)) {
			return;
		}

		if (selection.equals(QUIT_INPUT)) {
			return;
		}

		throw new IllegalArgumentException("1 또는 2 만 입력할 수 있습니다.");
	}

	public boolean isQuit() {
		return this.selection.equals(QUIT_INPUT);
	}
}
