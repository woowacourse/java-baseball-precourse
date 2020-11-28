package baseball;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Computer {
	Random random = new Random();
	HashMap<Integer, Integer> computerNumbersMap = new HashMap<Integer, Integer>();
	final int MAX_COMPUTER_KEY_NUMBERS = 3;

	public HashMap<Integer, Integer> inputComputerNumbers() {
		for (int num = 1; num <= MAX_COMPUTER_KEY_NUMBERS; num++) {
			computerNumbersMap.put(num, random.nextInt(10));
		}
		return computerNumbersMap;
	}

}
