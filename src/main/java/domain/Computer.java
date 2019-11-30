package domain;

import java.util.Random;

public class Computer {
	private int numbers[];
	private static final int LEN_NUMBERS = 3;
	private static final int NUM_RANGE = 10;
	
	public Computer() {
		numbers = new int[LEN_NUMBERS];
	}
	
	public void printNumbers() {
		for(int i=0; i<LEN_NUMBERS; i++) {
			System.out.println(numbers[i]);
		}
	}
	
	public void generateNumbers() {
		for(int i=0; i<LEN_NUMBERS; i++) {
			numbers[i] = generateRandomNumber();
		}
	}
	
	private int generateRandomNumber() {
		Random randGenerator = new Random();
		return randGenerator.nextInt(NUM_RANGE);
	}
}
