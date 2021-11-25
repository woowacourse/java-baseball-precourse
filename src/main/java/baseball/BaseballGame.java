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
			int[] answer = randomNumberGenerator.makeRandomNumber();
			playGame(answer);
		} while (restartGame());//TODO 재시작 여부
	}

	private boolean restartGame() {
		System.out.println(Message.REQUEST_RESTART_NUMBER);
		String requestInput = Console.readLine();
		Validation.checkRestartInput(requestInput);
		int inputValue = Integer.parseInt(requestInput);
		if (inputValue == 1) {
			running = true;
			return true;
		}
		System.out.println(Message.EXIT_GAME);
		return false;
	}

	private void playGame(int[] answer) {
		while (running) {
			System.out.print(Message.REQUEST_ENTER_NUMBER);
			String userInput = Console.readLine();
			Validation.checkInput(userInput);
			hint.countHint(answer, userInput);
			hint.printResult();

			if (hint.getStrike() == Rules.NUMBER_LENGTH) {
				System.out.println(Message.GAME_CLEAR);
				running = false;
			}
		}
	}
}
