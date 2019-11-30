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
	
	public void printGameResult(int[] userNumbers) {
		int strikeCounts = getStrikeCounts(userNumbers);
		int ballCounts = getBallCounts(userNumbers);
		
		if(strikeCounts != 0) {
			System.out.print(strikeCounts + " 스트라이크 ");
		}
		if(ballCounts != 0) {
			System.out.print(ballCounts + "볼");
		}
		if(strikeCounts == 0 && ballCounts == 0) {
			System.out.print("암것도 못맞췄지롱");
		}
//		System.out.print("\n");
	}
	
	private int getStrikeCounts(int[] userNumbers) {
		int strikeCounts = 0;
		
		for(int i=0; i<LEN_NUMBERS; i++) {
			if(userNumbers[i] == numbers[i]) {
				strikeCounts++;
			}
		}
		
		return strikeCounts;
	}
	
	private int getBallCounts(int[] userNumbers) {
		int ballCounts = 0;
		
		for(int i=0; i<LEN_NUMBERS; i++) {
			if((userNumbers[i] == numbers[(i + 1) % LEN_NUMBERS])
					|| (userNumbers[i] == numbers[(i + 2) % LEN_NUMBERS])) {
				ballCounts++;
			}
		}
		
		return ballCounts;
	}
}
