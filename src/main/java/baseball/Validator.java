package baseball;

public class Validator {	
	public static boolean isUseable(String random) {
		if (random.contains("0")) {
			return false;
		}
		
		for (int i = 0; i < GameManager.MAX_NUM_LENGTH; i++) {
			for (int j = i+1; j < GameManager.MAX_NUM_LENGTH; j++) {
				if (random.substring(i, i+1).equals(random.substring(j, j+1))) {
					return false;
				}
			}
		}
		
		return true;
	}
}
