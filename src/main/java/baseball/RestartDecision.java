package baseball;

public enum RestartDecision {
	RESTART(1),
	END(2);

	private final int decisionNumber;

	RestartDecision(int decisionNumber) {
		this.decisionNumber = decisionNumber;
	}

	public static RestartDecision from(int decisionNumber) {
		if (decisionNumber == RESTART.decisionNumber) {
			return RESTART;
		}
		if (decisionNumber == END.decisionNumber) {
			return END;
		}
		throw new IllegalArgumentException("입력은 1혹은 2여야 합니다.");
	}

	public boolean isRestart() {
		return this == RESTART;
	}
}
