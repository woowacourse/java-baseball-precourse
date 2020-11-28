package baseball;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import utils.RandomUtils;

public class Baseball {	
	static GameManager manager = new GameManager();
	static Player player = new Player();
	
	public static void start() {
		String randomNumber;
		String playerNumber;
		
		randomNumber = manager.getNumber();
		
		do {
			player.input();
			playerNumber = player.getNumber();
		} while(!Validator.isSame(randomNumber, playerNumber));
	}
}
