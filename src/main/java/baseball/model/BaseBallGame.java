package baseball.model;

import static baseball.constants.GameConfig.*;

import java.util.ArrayList;
import java.util.List;

import baseball.utils.AnswerGenerator;

public class BaseBallGame {
	Answer answer;
	InputValidator inputValidator;
	private boolean running;

	public BaseBallGame() {
		this.answer = AnswerGenerator.generate();
		this.inputValidator = new InputValidator();
		this.running = true;
	}

	public boolean isRunning() {
		return running;
	}

	public String evaluate(String guess) {
		inputValidator.validateGuess(guess);
		GuessNumbers guessNumbers = createGuessNumbers(guess, answer);

		if (guessNumbers.countStrike() == MAX_STRIKE) {
			endGame();
		}

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

	public void setRunning(String flag) {
		inputValidator.validateFlag(flag);

		if (flag.equals(RESTART_FLAG)) {
			restart();
		}
	}

	private void restart() {
		resetAnswer();
		restartGame();
	}

	private void resetAnswer() {
		this.answer = AnswerGenerator.generate();
	}

	private void restartGame() {
		this.running = true;
	}

	private void endGame() {
		this.running = false;
	}

}
