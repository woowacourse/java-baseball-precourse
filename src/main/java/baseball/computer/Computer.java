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

	public int checkBallCnt(String computerBall, String myAnswer) {
		int ballCnt = 0;
		String[] myAnswerArr = myAnswer.split("");

		for (int i = 0; i < 3; i++) {
			if (computerBall.charAt(i) == myAnswer.charAt(i)) {
				continue;
			}
			if (computerBall.contains(myAnswerArr[i])) {
				ballCnt++;
			}
		}

		return ballCnt;
	}

	public int checkStrikeCnt(String computerBall, String myAnswer) {
		int strikeCnt = 0;

		for (int i = 0; i < 3; i++) {
			if (computerBall.charAt(i) == myAnswer.charAt(i)) {
				strikeCnt++;
			}
		}

		return strikeCnt;
	}
}
