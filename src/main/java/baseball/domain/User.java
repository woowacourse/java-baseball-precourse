package baseball.domain;

public class User {
	private static final int NUMBER_LENGTH = 3;
	private final Integer[] expectedAnswer;

	public User() {
		this.expectedAnswer = new Integer[NUMBER_LENGTH];
	}

	public void setNumberOfUser(String number) {
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			this.expectedAnswer[i] = Character.getNumericValue(number.charAt(i));
		}
	}

	public Integer[] getExpectedAnswer() {
		return expectedAnswer;
	}

}
