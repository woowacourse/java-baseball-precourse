package baseball.model;

import static baseball.constants.GameConfig.*;

import java.util.ArrayList;
import java.util.List;

import baseball.utils.AnswerGenerator;

public class BaseBallGame {
	private Answer answer;
	private InputValidator inputValidator;
	private boolean running;

	public BaseBallGame() {
		this.answer = AnswerGenerator.generate();
		this.inputValidator = new InputValidator();
		this.running = true;
	}

	public boolean isRunning() {
		return running;
	}

	public Evaluation evaluate(String guess) {
		inputValidator.validateGuess(guess);

		return createEvaluation(guess, answer);
	}

	private Evaluation createEvaluation(String guess, Answer answer) {
		List<GuessNumber> guessNumbers = new ArrayList<>();

		for (int i = 0; i < guess.length(); i++) {
			guessNumbers.add(new GuessNumber(i, guess.charAt(i) - '0'));
		}

		return new Evaluation(guessNumbers, answer);
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

	public void endGame() {
		this.running = false;
	}

}
