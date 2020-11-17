package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum BaseballGameStatus {
	RESART("1"), EXIT("2");

	private static final String INVALID_INPUT_MESSAGE = "무효한 값입니다.";
	private static final Map<String, BaseballGameStatus> BaseballGameStatus = new HashMap<String, BaseballGameStatus>();
	static {
		for (BaseballGameStatus baseballGameStatus : values()) {
			BaseballGameStatus.put(baseballGameStatus.status, baseballGameStatus);
		}
	}

	private String status;

	BaseballGameStatus(String status) {
		Objects.requireNonNull(status);
		this.status = status;
	}

	public static BaseballGameStatus get(String status) {
		BaseballGameStatus baseballGameStatus = BaseballGameStatus.get(status);
		Objects.requireNonNull(baseballGameStatus, INVALID_INPUT_MESSAGE);
		return baseballGameStatus;
	}
}
