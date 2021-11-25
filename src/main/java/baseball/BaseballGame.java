package baseball;

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
		System.out.println(Message.REQUEST_RESTART_NUMBER);
		String requestInput = Console.readLine();
		System.out.println(requestInput);
		Validation.checkRestartInput(requestInput);
		if (requestInput.equals("1")) {
			running = true;
			return true;
		}
		System.out.println(Message.EXIT_GAME);
		return false;
	}

	private void playGame() {
		while (running) {
			System.out.print(Message.REQUEST_ENTER_NUMBER);
			String userInput = Console.readLine();
			Validation.checkInput(userInput);
			hint.countHint(randomNumberGenerator.getAnswer(), userInput);
			hint.printResult();

			if (hint.getStrike() == Rules.NUMBER_LENGTH) {
				System.out.println(Message.GAME_CLEAR);
				running = false;
			}
		}
	}
}
