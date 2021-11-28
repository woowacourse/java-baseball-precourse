package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private String answerBalls;

	public Computer() {
		this.answerBalls = "";
	}

	public void determineAnswerBalls() {
		List<Integer> randoms = new ArrayList<>();
		while (randoms.size() < 3) {
			int random = Randoms.pickNumberInRange(1, 9);
			if (!randoms.contains(random)) {
				randoms.add(random);
			}
		}
		String answerBalls = "";
		for (Integer random : randoms) {
			answerBalls += random;
		}

		this.answerBalls = answerBalls;
	}

	public Hint compareBalls(String prediction) {
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < prediction.length(); i++) {
			int result = answerBalls.indexOf(prediction.charAt(i));
			if (result == i) {
				strike++;
			}
			if (result != -1) {
				ball++;
			}
		}
		return new Hint(strike, ball - strike);
	}
}
