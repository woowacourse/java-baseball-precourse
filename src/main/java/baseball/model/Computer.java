package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private final String number;
	
	public Computer() {
		this.number = String.valueOf(Randoms.pickNumberInRange(0, 999));
	}
	
	public String getNumber() {
		return this.number;
	}
}