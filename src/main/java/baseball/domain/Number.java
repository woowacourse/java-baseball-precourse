package baseball.domain;

public class Number {

	private static final int MIN = 1;
	private static final int MAX = 9;
	private final int no;

	public Number(int no) {
		if (no < MIN || MAX < no) {
			throw new IllegalArgumentException();
		}
		this.no = no;
	}

}
