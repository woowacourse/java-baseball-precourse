package baseball.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baseball.constants.Constant;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private static Computer instance = new Computer();
	private static List<Integer> answer = new ArrayList<>();

	private Computer() {
	}

	public static Computer getInstance() {
		if (instance == null) {
			return new Computer();
		}
		generateRandomAnswer();
		return instance;
	}

	private static void generateRandomAnswer() {
		answer = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			int number = Randoms.pickNumberInRange(1, 9);
			if (answer.contains(number)) {
				i--;
				continue;
			}
			answer.add(number);
		}
	}

	public Map<String, Integer> generateHint(int[] playerNumber) {
		Map<String, Integer> hint = new HashMap<>();
		int strikeCount = 0;
		int ballCount = 0;

		for (int i = 0; i < 3; i++) {
			if (playerNumber[i] == answer.get(i)) {
				strikeCount++;
			} else if (answer.contains(playerNumber[i])) {
				ballCount++;
			}
		}

		hint.put(Constant.BALL, ballCount);
		hint.put(Constant.STRIKE, strikeCount);

		return hint;
	}
}
