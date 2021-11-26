package baseball.domain;

import static baseball.constants.GameConstants.Digit.*;
import static baseball.constants.GameConstants.GameOverInput.*;
import static baseball.constants.GameConstants.Terminology.*;

import java.util.stream.IntStream;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
	private final Computer computer;
	private final Player player;
	private final UserGameSelection userGameSelection;
	private int ball, strike;

	public Game(Computer computer, Player player) {
		this(computer, player, new UserGameSelection(RESTART));
	}

	public Game(Computer computer, Player player, UserGameSelection userGameSelection) {
		resetGameResult();
		this.computer = computer;
		this.player = player;
		this.userGameSelection = userGameSelection;
	}

	private void resetGameResult() {
		this.ball = 0;
		this.strike = 0;
	}

	public void runGameOnce() {
		while (true) {
			OutputView.printInputHint();
			player.setNumberList(InputView.inputUserNumber());
			runComparison();
			OutputView.printGameResult(this);
			if (strike == LENGTH.getNumber()) {
				userGameSelection.setUserGameSelection(InputView.inputUserGameOverSelection());
				break;
			}
		}
	}

	public void runComparison() {
		resetGameResult();

		IntStream.range(0, player.getNumberList().size()).forEach(position -> {
			int playerNumber = player.getNumberList().get(position);
			boolean isNumberCorrect = computer.getNumberOccurrences().containsKey(playerNumber);
			boolean isPositionCorrect =
				isNumberCorrect && computer.getNumberOccurrences().get(playerNumber).equals(position);
			if (isNumberCorrect && isPositionCorrect)
				this.strike += 1;
			if (isNumberCorrect && !isPositionCorrect)
				this.ball += 1;
		});
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

	public int getStrike() {
		return strike;
	}
}
