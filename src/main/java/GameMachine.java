import domain.BaseBallGame;
import generator.RandomGameNumbersGenerator;
import io.InputView;

public class GameMachine {

	private InputView inputView;

	GameMachine() {
		this.inputView = new InputView(System.in);
	}

	void runBaseBallGameOnce() {
		BaseBallGame baseBallGame = new BaseBallGame(new RandomGameNumbersGenerator());
		baseBallGame.executeUserInput(this.inputView);
	}
}
