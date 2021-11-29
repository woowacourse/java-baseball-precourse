package baseball;

import java.util.List;

public class BaseballGame {
	private List<Integer> computer;
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private Judgement judgement = new Judgement();

	public BaseballGame() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		computer = randomNumberGenerator.generate();
	}

	public void playGame() {
		while (true) {
			List<Integer> player = inputView.getPredictionNumber();
			PlayResult playresult = judgement.play(computer, player);
			outputView.printPredictionResult(playresult);
			if (playresult.isGameEnd()) {
				outputView.printGameEndMessage();
				break;
			}
		}
	}

	public boolean isQuit() {
		return inputView.getQuitOrNot();
	}
}
