package baseball;

public class Validator {
	public static boolean isSame(String random, String playerNumber) {
		if (random.equals(playerNumber)) {
			return true;
		}
		return false;
	}
}
