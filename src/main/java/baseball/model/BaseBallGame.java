package baseball.model;

import java.util.HashMap;
import java.util.Set;

import baseball.utils.AnswerGenerator;

public class BaseBallGame {
	private boolean running;
	Set<Integer> answer;

	public BaseBallGame() {
		this.running = true;
		this.answer = AnswerGenerator.generate();
	}

	public boolean isRunning() {
		return running;
	}

	public void evaluate(String guess) {
		validateInput(guess);
		// TODO: 평가
	}

	private void validateInput(String input) {
		String pattern = "[1-9]{3}";

		if (!input.matches(pattern)) {
			throw new IllegalArgumentException("세 자리의 숫자를 입력해야 합니다.");
		}

		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (char numChar : input.toCharArray()) {
			hashMap.put(numChar, hashMap.getOrDefault(numChar, 0) + 1);
		}
		for (int num : hashMap.values()) {
			if (num > 1) {
				System.out.println("정답은 서로 다른 세 자리 수입니다.");
			}
		}
	}

}
