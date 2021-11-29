package baseball.domain.game;

import java.util.Arrays;

public enum ContinueType {
	CONTINUE("1", true),
	STOP("2", false);

	private String code;
	private boolean bool;

	ContinueType(String code, boolean bool) {
		this.code = code;
		this.bool = bool;
	}

	public static boolean toBeContinued(String input) {
		return Arrays.stream(ContinueType.values())
			.filter(continueType -> continueType.code.equals(input))
			.map(continueType -> continueType.bool)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다. 1 또는 2를 입력해주세요."));
	}
}
