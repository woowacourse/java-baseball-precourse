package baseball.type;

public enum StatusType {
	RESTART("1"),
	FINISH("2"),
	;

	private String status;

	StatusType(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
