package baseball.model;

import baseball.play.Validation;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private String number = "";
	
	public Computer() {
		generateNumber();
	}
	
	public String getNumber() {
		return this.number;
	}

	public void generateNumber() {
		String randomNumber = String.valueOf(Randoms.pickNumberInRange(0, 999));
		try {
			new Validation(randomNumber);
			this.number = randomNumber;
		} catch (IllegalArgumentException e) {
			generateNumber();
		}
	}
}