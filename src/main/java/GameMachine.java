import domain.BaseBallGame;
import generator.RandomGameNumbersGenerator;
import io.InputView;

class GameMachine {

	private final int START = 1;
	private final int END = 2;

	private InputView inputView;

	GameMachine() {
		this.inputView = new InputView(System.in);
	}

	void runBaseBallGameOnce() {
		BaseBallGame baseBallGame = new BaseBallGame(new RandomGameNumbersGenerator());
		baseBallGame.executeUserInput(this.inputView);
		startNewBaseBallGame();
	}

	private void startNewBaseBallGame() {
		int newGameResponse = inputView.newGame();
		validateNewGameInput(newGameResponse);
		if (newGameResponse == START)
			runBaseBallGameOnce();
	}

	private void validateNewGameInput(int newGameResponse) {
		if (newGameResponse != START && newGameResponse != END)
			throw new IllegalArgumentException("잘못된 입력값 입니다");
	}
}
