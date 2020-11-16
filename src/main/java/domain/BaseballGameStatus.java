package domain;

import java.util.Arrays;

public enum BaseballGameStatus {
	RESART("1"), EXIT("2");

	private final static String INVALID_INPUT_MESSAGE = "무효한 값입니다.";
	private String status;

	BaseballGameStatus(String status) {
		this.status = status;
	}

	public static BaseballGameStatus get(String status) {
		return Arrays.stream(BaseballGameStatus.values())
				.filter(baseballGameStatus -> baseballGameStatus.status.equals(status)).findAny()
				.orElseThrow(() -> new IllegalArgumentException(INVALID_INPUT_MESSAGE));
	}
}
