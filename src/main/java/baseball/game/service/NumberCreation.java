package baseball.game.service;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberCreation {

	public static int[] createRandomNumber() {

		int[] answer = new int[3];
		boolean[] selected = new boolean[9];

		for (int index = 0; index < 3; index++) {
			int number = Randoms.pickNumberInRange(1, 9);

			if (!selected[number - 1]) {
				selected[number - 1] = true;
				answer[index] = number;
				continue;
			}
			index--;
		}

		return answer;
	}
}
