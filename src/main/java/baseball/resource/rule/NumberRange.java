package baseball.resource.rule;

public enum NumberRange {

	START(1), END(9);

	private final int number;

	NumberRange(int number) {
		this.number = number;
	}

	public static int getStart() {
		return START.number;
	}

	public static int getEnd() {
		return END.number;
	}

	public static boolean isOutOfRange(int number) {
		return (number < START.number || END.number < number);
	}

}
