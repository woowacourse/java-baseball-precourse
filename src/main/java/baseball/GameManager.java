package baseball;

import utils.RandomUtils;

public class GameManager {
	private final static int START_INCLUSIVE = 100;
	private final static int END_INVLUSIVE = 999;
	
	public String getNumber() {
		int random = RandomUtils.nextInt(START_INCLUSIVE, END_INVLUSIVE);
		
		
		return Integer.toString(random);
	}
}
