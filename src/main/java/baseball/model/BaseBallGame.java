package baseball.model;

import static baseball.constants.GameConfig.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.utils.AnswerGenerator;

public class BaseBallGame {
	private boolean running;
	Answer answer;

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

	private GuessNumbers createGuessNumbers(String guess, Answer answer) {
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
		validateRange(input);
		validateLength(input);
		validateDuplication(input);
	}

	private void validateRange(String input) {
		String pattern = "[1-9]+";

		if (!input.matches(pattern)) {
			throw new IllegalArgumentException("각 자리 수는 1이상 9이하의 정수입니다.");
		}
	}

	private void validateLength(String input) {
		if (input.length() != ANSWER_LENGTH) {
			throw new IllegalArgumentException("세 자리 수를 입력해주세요.");
		}
	}

	private void validateDuplication(String input) {
		Set<Character> hashSet = new HashSet<>();
		for (char numChar : input.toCharArray()) {
			hashSet.add(numChar);
		}

		if (hashSet.size() != ANSWER_LENGTH) {
			throw new IllegalArgumentException("서로 다른 세 자리 수를 입력해주세요.");
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
