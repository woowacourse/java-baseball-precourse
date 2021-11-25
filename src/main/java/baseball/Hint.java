package baseball;

import java.util.HashMap;

public class Hint {
	public static HashMap<String, Integer> getHint(int[] randomNumbers, int[] userInputNumbers) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("ball", 0);
		map.put("strike", 0);
		boolean[] checkArray = new boolean[10];
		for (int i = 0; i < randomNumbers.length; i++) {
			checkArray[randomNumbers[i]] = true;
		}
		for (int i = 0; i < userInputNumbers.length; i++) {
			if (randomNumbers[i] == userInputNumbers[i]) {
				map.put("strike", map.get("strike") + 1);
			} else if (checkArray[userInputNumbers[i]]) {
				map.put("ball", map.get("ball") + 1);
			}
		}
		return map;
	}
}
