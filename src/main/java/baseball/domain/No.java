package baseball.domain;

import java.util.Objects;

public class No {
	public static final int MIN_NO = 1;
	public static final int MAX_NO = 9;

	private final int no;

	public No(int no) {
		checkValid(no);
		this.no = no;
	}

	private void checkValid(int no) {
		if (!(no >= MIN_NO && no <= MAX_NO)) {
			throw new IllegalArgumentException("1부터 9 사이의 숫자를 입력하세요.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		No index1 = (No)o;
		return no == index1.no;
	}

	@Override
	public int hashCode() {
		return Objects.hash(no);
	}
}
