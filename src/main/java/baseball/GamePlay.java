package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class GamePlay {
	public static void getRandomNumbers() {
		int[] randomNumbers = new int[3];
		boolean[] checkArray = new boolean[10];
		int number;
		int index = 0;
		while (index < 3) {
			number = Randoms.pickNumberInRange(1, 9);
			if (!checkArray[number]) {
				checkArray[number] = true;
				randomNumbers[index] = number;
				index++;
			}
		}
		System.out.println(Arrays.toString(randomNumbers));
	}
}
