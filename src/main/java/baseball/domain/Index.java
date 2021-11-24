package baseball.domain;

import java.util.Objects;

public class Index {
	public static final int MIN_NO = 0;
	public static final int MAX_NO = 2;

	private final int index;

	public Index(int index) {
		checkValid(index);
		this.index = index;
	}

	private void checkValid(int index) {
		if (!(index >= MIN_NO && index <= MAX_NO)) {
			throw new IllegalArgumentException("0부터 2 사이의 숫자를 입력하세요.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Index index1 = (Index)o;
		return index == index1.index;
	}

	@Override
	public int hashCode() {
		return Objects.hash(index);
	}
}
