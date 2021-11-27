package baseball.domain;

import baseball.type.ExceptionType;
import baseball.type.NumberRangeType;
import baseball.type.StatusType;
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
		String enterPlayerNumber = player.enterInput();
		validateRestartOrFinishNumber(enterPlayerNumber);
		return enterPlayerNumber.equals(StatusType.RESTART.getStatus());
	}

	private void validateRestartOrFinishNumber(String enterPlayerNumber) {
		if (!enterPlayerNumber.equals(StatusType.RESTART.getStatus()) && !enterPlayerNumber.equals(
			StatusType.FINISH.getStatus())) {
			throw new IllegalArgumentException(ExceptionType.NOT_RESTART_AND_FINISH.getMessage());
		}
	}

	public void generateAnswerNumbers() {
		computer.generateAnswerNumbers();
	}
}
