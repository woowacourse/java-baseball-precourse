package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

	public static void play() {
		int[] answer = generateAnswer();
		System.out.println(Arrays.toString(answer));
	}

	private static int[] generateAnswer() {
		int[] answer = new int[3];
		for (int i = 0; i < answer.length; i++) {
			insertUniqueNumber(answer, i);
		}

		return answer;
	}

	private static void insertUniqueNumber(int[] arr, int index) {
		while (true) {
			int r = Randoms.pickNumberInRange(1, 9);

			if (contains(arr, index, r))
				continue;
			else {
				arr[index] = r;
				break;
			}
		}
	}

	private static boolean contains(int[] arr, int index, int num) {
		for (int i = 0; i < index; i++)
			if (arr[i] == num)
				return true;

		return false;
	}

}
