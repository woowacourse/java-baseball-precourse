package domain;

public class RestartOrEndSelection {
	private static final String RESTART_INPUT = "1";
	private static final String END_INPUT = "2";

	private final String selection;

	public RestartOrEndSelection(String selection) {
		validateSelection(selection);
		this.selection = selection;
	}

	private void validateSelection(String selection) {
		if (selection.equals(RESTART_INPUT) || selection.equals(END_INPUT)) {
			return;
		}
		throw new IllegalArgumentException("1(재시작) 또는 2(종료)를 입력해야 합니다.");
	}

	public boolean isRestart() {
		return this.selection.equals(RESTART_INPUT);
	}
}
