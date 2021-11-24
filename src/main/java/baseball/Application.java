package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		GameManager gameManager = createGameManager();
		run(gameManager);
	}

	private static GameManager createGameManager() {
		Display display = new Display();
		BaseballNumberValidator validator = new BaseballNumberValidator();
		BaseballNumberGenerator generator = new BaseballNumberGenerator(validator);
		BaseballNumberReferee referee = new BaseballNumberReferee(validator);
		JudgeResultFormatter formatter = new JudgeResultFormatter();
		return new GameManager(display, generator, referee, formatter);
	}

	private static void run(GameManager gameManager) {
		gameManager.startGame();

		while (!gameManager.isGameFinished()) {
			handleInput(gameManager);
		}
	}

	private static void handleInput(GameManager gameManager) {
		gameManager.handleGuessNumber(Console.readLine());

		if (gameManager.isGameFinished()) {
			gameManager.handleOptionNumber(Console.readLine());
		}
	}
}
