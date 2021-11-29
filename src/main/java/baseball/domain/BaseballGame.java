package baseball.domain;

import baseball.type.NumberRangeType;
import baseball.view.BaseballGameView;

public class BaseballGame {

	private Computer computer;
	private Player player;

	public BaseballGame() {
		this.computer = new Computer();
		this.player = new Player();
	}

	public void startBaseballGame() {
		while (true) {
			BaseballGameView.printInputPlayerNumber();
			player.generatePlayerNumber();
			Result result = new Result(computer.getComputerNumbers(), player.getPlayerNumbers());
			BaseballGameView.printResultOfGame(result);
			if (isAnswer(result)) {
				BaseballGameView.printEndGame();
				break;
			}
		}
	}

	private boolean isAnswer(Result result) {
		return result.getStrike() == NumberRangeType.ANSWER_SIZE.getNumberRange();
	}

	public boolean isRestart() {
		BaseballGameView.printRestartOrFinishGameMessage();
		return player.selectRestartOrFinish();
	}

	public void generateAnswerNumbers() {
		computer.generateAnswerNumbers();
	}
}
