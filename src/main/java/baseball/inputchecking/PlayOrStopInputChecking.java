package baseball.inputchecking;

public class PlayOrStopInputChecking implements InputChecking {

	@Override
	public void inputCheck(String input) throws IllegalArgumentException {
		// input 값의 길이가 1이 아닐 경우 예외 발생
		if (input.length() != 1) {
			throw new IllegalArgumentException();
		}

		// input 의 값이 숫자가 아닌 다른 값이 들어올 경우 예외 발생
		char inputChar = input.charAt(0);
		if (!Character.isDigit(inputChar)) {
			throw new IllegalArgumentException();
		}

		// input 의 값이 1 또는 2가 아닌 다른 값일 경우 예외 발생
		int number = Integer.parseInt(input);
		if (number != 1 && number != 2) {
			throw new IllegalArgumentException();
		}
	}
}
