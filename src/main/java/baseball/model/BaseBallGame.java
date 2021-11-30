package baseball.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import baseball.utils.AnswerGenerator;

public class BaseBallGame {
	private boolean running;
	List<Integer> answer;

	public BaseBallGame() {
		this.running = true;
		this.answer = AnswerGenerator.generate();
	}

	public boolean isRunning() {
		return running;
	}

	public String evaluate(String guess) {
		validateInput(guess);
		GuessNumbers guessNumbers = createGuessNumbers(guess, answer);

		if (guessNumbers.countStrike() == 3) {
			this.running = false;
		}

		System.out.println(answer.toString());
		
		Report report = new Report(guessNumbers);
		return report.getReport();

	}

	private GuessNumbers createGuessNumbers(String guess, List<Integer> answer) {
		List<GuessNumber> guessNumbers = new ArrayList<>();

		for (int i = 0; i < guess.length(); i++) {
			guessNumbers.add(createGuessNumber(i, guess.charAt(i) - '0'));
		}

		return new GuessNumbers(guessNumbers);
	}

	private GuessNumber createGuessNumber(int idx, int val) {
		if (answer.contains(val) && answer.indexOf(val) == idx) {
			return new GuessNumber(idx, val, "STRIKE");
		}

		if (answer.contains(val)) {
			return new GuessNumber(idx, val, "BALL");
		}

		return new GuessNumber(idx, val, "WRONG");
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

	public void setRunning(String input) {
		if (input.equals("1")) {
			this.answer = AnswerGenerator.generate();
			this.running = true;
		}

		// TODO : validation

	}

}
