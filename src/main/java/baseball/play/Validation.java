package baseball.play;

import baseball.util.GameUtil;

public class Validation {
	
//	public enum Validateion {
//		SUCCESS,
//		FAIL
//	}
	
	public static boolean intToStringCheck(String strNumber) {
		try {
			Integer.parseInt(strNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean numberCheck(int userNumber) {
		if (GameUtil.getNumberLength(userNumber) != 3) {
			throw new IllegalArgumentException();	
		} 
		if (userNumber < 1) {
			throw new IllegalArgumentException();
		}
		
		return true;
	}
}
