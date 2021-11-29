package baseball;

import static utils.Constant.*;

import java.util.HashSet;
import java.util.Set;

public class Validator {
	public static boolean checkInputNumber(String str) {
		if (str.length() != GAME_NUMBER_LENGTH) {
			return false;
		}
		if (str.contains(ZERO_STRING)) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}

		Set<Character> s = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			s.add(str.charAt(i));
		}
		if (s.size() != GAME_NUMBER_LENGTH) {
			return false;
		}
		return true;
	}

	public static boolean checkRestartOrFinishCommand(String str) {
		return str.equals(RESTART_COMMAND) || str.equals(FINISH_COMMAND);
	}

}
