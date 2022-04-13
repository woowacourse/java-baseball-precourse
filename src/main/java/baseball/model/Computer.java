package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private int number;
	
	public int getNumber() {
		return this.number;
	}
	
	public Computer() {
		this.number = Randoms.pickNumberInRange(0, 999);
	}
	
}
