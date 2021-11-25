package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

	public static void play() {
		int[] answerNumber = generateAnswer();
		System.out.println(Arrays.toString(answerNumber)); // 생성된 난수 확인 위한 코드 추후 제거


	}

	private static int[] generateAnswer() {
		int[] answer = new int[Const.ANSWER_SIZE];
		for (int i = 0; i < answer.length; i++) {
			insertUniqueNumber(answer, i);
		}

		return answer;
	}

	private static void insertUniqueNumber(int[] arr, int index) {
		while (true) {
			int r = Randoms.pickNumberInRange(Const.MIN_ANSWER_VALUE, Const.MAX_ANSWER_VALUE);

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
