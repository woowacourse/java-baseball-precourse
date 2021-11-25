package baseball.type;

public enum NumberRangeType {
	MIN_NUMBER(1),
	MAX_NUMBER(9),
	ANSWER_SIZE(3),
	;

	private int numberRange;

	NumberRangeType(int numberRange) {
		this.numberRange = numberRange;
	}

	public int getNumberRange() {
		return numberRange;
	}
}
