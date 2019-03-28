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
	 * 1-9까지 서로 다른 임의의 세가지 수를 선택하여 numbers에 저장. 
	 * 숫자를 랜덤하게 선택한 후 그 숫자와 마지막 숫자를 바꾸고
	 * 다시 남은 수 중에서 랜덤하게 선택하는 방식으로 서로 다른 임의의 세가지 수 생성 
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
