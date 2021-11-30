package baseball.number;

import java.util.Objects;

public class Number {
	public static final int MIN = 1;
	public static final int MAX = 9;
	private final int number;

	private Number(int number) {
		validateNumber(number);
		this.number = number;
	}

	public static Number valueOf(char ch){
		int number = convertToNumeric(ch);
		return new Number(number);
	}

	public static Number valueOf(int n){
		return new Number(n);
	}

	private static int convertToNumeric(char ch){
		validateDigit(ch);
		return Character.getNumericValue(ch);
	}

	private static void validateDigit(char ch){
		if(!Character.isDigit(ch)){
			throw new IllegalArgumentException("숫자를 제외한 문자는 허용되지 않습니다.");
		}
	}

	private static void validateNumber(int n){
		if(n<MIN||n>MAX){
			throw new IllegalArgumentException("숫자의 범위를 초과했습니다.");
		}
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Number))
			return false;
		Number n = (Number)o;
		return this.number == n.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
