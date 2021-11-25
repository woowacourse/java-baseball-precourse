package baseball.domain;

import static baseball.constants.GameConstants.Digit.*;
import static baseball.constants.GameConstants.Terminology.*;

import java.util.List;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
	private Computer computer;
	private Player player;
	private int ball, strike;

	public Game() {
		resetGameResult();
		this.computer = new Computer();
		this.player = new Player();
	}

	private void resetGameResult() {
		this.ball = 0;
		this.strike = 0;
	}

	public int runGameOnce() {
		int userGameOverSelection;
		while (true) {
			OutputView.printInputHint();
			List<Integer> userNumberList = InputView.inputUserNumber();
			player.setNumberList(userNumberList);
			runComparison();
			OutputView.printGameResult(this);
			if (strike == LENGTH.getNumber()) {
				userGameOverSelection = InputView.inputUserGameOverSelection();
				break;
			}
		}
		return userGameOverSelection;
	}

	public void runComparison() {
		resetGameResult();

		for (int position = 0; position < player.getNumberList().size(); position++) {
			int playerNumber = player.getNumberList().get(position);
			boolean isNumberCorrect = computer.getNumberOccurrences().containsKey(playerNumber);
			boolean isPositionCorrect =
				isNumberCorrect && computer.getNumberOccurrences().get(playerNumber).equals(position);
			if (isNumberCorrect && isPositionCorrect)
				this.strike += 1;
			if (isNumberCorrect && !isPositionCorrect)
				this.ball += 1;
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		if (strike == 0 && ball == 0)
			stringBuilder.append(NOTHING.getString());
		if (ball > 0)
			stringBuilder.append(ball).append(BALL.getString());
		if (strike > 0) {
			if (ball > 0)
				stringBuilder.append(' ');
			stringBuilder.append(strike).append(STRIKE.getString());
		}
		return stringBuilder.toString();
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getStrike() {
		return strike;
	}
}
