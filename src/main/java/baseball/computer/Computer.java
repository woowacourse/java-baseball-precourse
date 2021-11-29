package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	public String createRandomBalls() {
		boolean[] isBallAppeared = new boolean[10];

		StringBuilder threeBalls = new StringBuilder();

		int cnt = 0;

		while (cnt < 3) {
			int randomNum = Randoms.pickNumberInRange(1, 9);
			if (!isBallAppeared[randomNum]) {
				isBallAppeared[randomNum] = true;
				threeBalls.append(randomNum);
				cnt++;
			}
		}

		return threeBalls.toString();
	}
}
