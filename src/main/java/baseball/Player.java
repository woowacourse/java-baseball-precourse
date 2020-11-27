package baseball;

import java.util.Scanner;

public class Player {
	Scanner scanner = new Scanner(System.in);
	StringGameGuide guide = new StringGameGuide();
	
	private int inputThreeNumbers() {
		int inputNumbers = scanner.nextInt();
		return inputNumbers;
	}
	
	public int[] duplicateThreeNumbers() {
		System.out.println(guide.InputNumbers());
		int[] numbersAmount = new int[3];
		
		for (int num =0; num <= numbersAmount.length; num++) {
			numbersAmount[num] = inputThreeNumbers();
		}
		return numbersAmount;
	}
	
	
}
