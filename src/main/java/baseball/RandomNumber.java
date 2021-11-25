package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
	public static final int PICK_NUMBER = 3;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 9;

	public static int[] getRandomNumbers() {
		int[] randomNumbers = new int[PICK_NUMBER];
		boolean[] checkArray = new boolean[10];
		int index = 0;
		while (index < PICK_NUMBER) {
			int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			if (!checkArray[number]) {
				checkArray[number] = true;
				randomNumbers[index] = number;
				index++;
			}
		}
		System.out.println(Arrays.toString(randomNumbers));
		return randomNumbers;
	}
}
