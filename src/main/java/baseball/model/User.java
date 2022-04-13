package baseball.model;

import baseball.play.Validation;

public class User {

	private int number;
	
	public void setNumber(int inputNumber) {
		if (!Validation.numberCheck(inputNumber)) {
			throw new IllegalArgumentException();
		}
		this.number = inputNumber;
	}
}
