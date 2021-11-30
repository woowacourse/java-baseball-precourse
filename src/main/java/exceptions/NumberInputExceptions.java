package exceptions;

public class NumberInputExceptions extends IllegalArgumentException {
	public NumberInputExceptions() {
		super("잘못된 사용자 입력 입니다.");
	}
}
