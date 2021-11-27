package baseball.type;

public enum NumberRangeType {
	MIN_NUMBER(1),
	MAX_NUMBER(9),
	ANSWER_SIZE(3),
	MIN_NUMBER_ASCII(49),
	MAX_NUMBER_ASCII(57),
	ZERO(0),
	;

	private int numberRange;

	NumberRangeType(int numberRange) {
		this.numberRange = numberRange;
	}

	public int getNumberRange() {
		return numberRange;
	}
}
