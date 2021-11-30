package baseball.type;

public enum Answer {
	CORRECT, INCORRECT;

	public boolean isCorrect(){
		return this == Answer.CORRECT;
	}
}
