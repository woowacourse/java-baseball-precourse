package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {	
	public static boolean isUseable(String random) {
		Set<String> set;
		List<String> randomList = Arrays.asList(random.split(""));
		
		set = new HashSet<String>(randomList);
		
		if (random.contains("0")) {
			return false;
		}
		
		return set.size() == GameManager.MAX_NUM_LENGTH;
	}
}
