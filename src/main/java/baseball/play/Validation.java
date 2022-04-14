package baseball.play;

import baseball.util.GameUtil;

public class Validation {
	
	public enum ValidType {
		SUCCESS,
		TYPE_NO_MATCH,
		DIGIT_NO_MATCH,
		LESS_THAN_ZERO,
		DUPLICATION_NUMBER, //TODO:
		
		FAIL
	}
	
	public static ValidType numberCheck(String strInputNumber) {
		int number;
		try {
			number = Integer.parseInt(strInputNumber);
		} catch (NumberFormatException e) {
			return ValidType.TYPE_NO_MATCH;
		}
		if (GameUtil.getNumberLength(number) != 3) {
			return ValidType.DIGIT_NO_MATCH;
		} 
		if (number < 1) {
			return ValidType.LESS_THAN_ZERO;
		}
		
		return ValidType.SUCCESS;
	}
	
	
	
	
	
	
	
}
