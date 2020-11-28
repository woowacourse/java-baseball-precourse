package baseball;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
	final static int MAX_LENGTH = 3;
	final static int START_GAME = 1;
	final static int END_GAME = 2;
	final static int MAX_RANGE = 9;
	final static int MIN_RANGE = 1;
	
	String[] randomNumbers = new String[MAX_LENGTH];
	
	public void randomNumberDuplicate() {
		for(int i = 0;i < MAX_LENGTH;i++){
			int random = RandomUtils.nextInt(MIN_RANGE, MAX_LENGTH);
			randomNumbers[i] = String.valueOf(random);	
		}
		
	}
}
