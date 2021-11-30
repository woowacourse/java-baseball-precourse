package baseball.domain;

public class Number {

	private static final String NUMBER_ERROR = "1에서 9까지의 숫자를 입력해주세요.";

	private static final int MIN = 1;
	private static final int MAX = 9;
	private final int no;

	public Number(int no) {
		validate(no);
		this.no = no;
	}

	public void validate(int no) {
		if (no < MIN || MAX < no) {
			throw new IllegalArgumentException(NUMBER_ERROR);
		}
	}

	public int getNo() {
		return no;
	}
}
