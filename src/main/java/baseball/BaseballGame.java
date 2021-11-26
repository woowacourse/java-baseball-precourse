package baseball;

import static baseball.Message.*;
import static baseball.Rules.*;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
	private RandomNumberGenerator randomNumberGenerator;
	private Hint hint;
	private boolean running;

	public BaseballGame() {
		this.randomNumberGenerator = new RandomNumberGenerator();
		this.hint = new Hint();
		this.running = true;
	}

	public void start() {
		do {
			randomNumberGenerator.makeRandomNumber();
			playGame();
		} while (restartGame());
	}

	private boolean restartGame() {
		System.out.println(REQUEST_RESTART_NUMBER);
		String requestInput = Console.readLine();
		Validation.checkRestartInput(requestInput);
		if (requestInput.equals("1")) {
			running = true;
			return true;
		}
		System.out.println(EXIT_GAME);
		return false;
	}

	private void playGame() {
		while (running) {
			System.out.print(REQUEST_ENTER_NUMBER);
			String userInput = Console.readLine();
			Validation.checkInput(userInput);
			hint.countHint(randomNumberGenerator.getAnswer(), userInput);
			hint.printResult();

			if (hint.getStrike() == NUMBER_LENGTH) {
				System.out.println(GAME_CLEAR);
				running = false;
			}
		}
	}
}
