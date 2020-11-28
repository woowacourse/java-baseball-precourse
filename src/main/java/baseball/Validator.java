package baseball;

public class Validator {
	public static boolean isSame(String origin, String compare) {
		if (origin.equals(compare)) {
			return true;
		}
		return false;
	}
	
	public static boolean isUseable(String random) {
		if (random.contains("0")) {
			return false;
		}
		
		for (int i = 0; i < GameManager.MAX_NUM_LENGTH; i++) {
			for (int j = i+1; j < GameManager.MAX_NUM_LENGTH; j++) {
				if (isSame(random.substring(i, i+1), random.substring(j, j+1))) {
					return false;
				}
			}
		}
		
		return true;
	}
}
