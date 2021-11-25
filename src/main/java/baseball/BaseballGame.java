package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
	private RandomNumberGenerator randomNumberGenerator;
	private Hint hint;

	public BaseballGame() {
		this.randomNumberGenerator = new RandomNumberGenerator();
		this.hint = new Hint();
	}

	public void start() {
		do {
			int[] answer = randomNumberGenerator.makeRandomNumber();
			playGame(answer);
		} while (true);//TODO 재시작 여부

	}

	private void playGame(int[] answer) {
		while (true) {
			System.out.print(Message.REQUEST_ENTER_NUMBER);
			String userInput = Console.readLine();
			Validation.checkInput(userInput);
			hint.countHint(answer, userInput);
			hint.printResult();

			if (hint.getStrike() == Rules.NUMBER_LENGTH) {
				System.out.println(Message.GAME_CLEAR);
			}


		}
	}
}
