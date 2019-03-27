/*
 * Computer
 * 
 * version 1.0
 * 
 * 2019. 3. 27
 * 
 * Created by Wongeun Song
 */

import java.util.Random;

public class Computer {
	int[] numbers = new int[3];
	
	/**
	 * 1-9까지 서로 다른 임의의 세개 수를 선택하여 numbers에 저장
	 */
	public void generateNumbers() {
		int[] digits = {1,2,3,4,5,6,7,8,9};
		Random random = new Random();
		int randomIndex;
		
		randomIndex = random.nextInt(9);
		numbers[0] = digits[randomIndex];
		digits[randomIndex] = 9;
		randomIndex = random.nextInt(8);
		numbers[1] = digits[randomIndex];
		digits[randomIndex] = 8;
		randomIndex = random.nextInt(7);
		numbers[2] = digits[randomIndex];
		digits[randomIndex] = 7;
	}
}
