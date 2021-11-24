package baseball.domain;

import static baseball.constants.GameConstants.Digit.*;
import static baseball.constants.GameConstants.GameOverInput.*;
import static baseball.constants.GameConstants.Terminology.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import baseball.constants.GameConstants;
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
		List<Integer> playerNumberList = player.getNumberList();
		List<Integer> computerNumberList = computer.getNumberList();
		resetGameResult();

		Map<Integer, Integer> occurrences = new TreeMap<>();
		for (int i = 0; i < computerNumberList.size(); i++)
			occurrences.put(computerNumberList.get(i), i);

		for (int position = 0; position < playerNumberList.size(); position++) {
			int playerNumber = playerNumberList.get(position);
			boolean isNumberCorrect = occurrences.containsKey(playerNumber);
			boolean isPositionCorrect = isNumberCorrect && occurrences.get(playerNumber).equals(position);
			if (isNumberCorrect && isPositionCorrect)
				this.strike += 1;
			if (isNumberCorrect && !isPositionCorrect)
				this.ball += 1;
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		if (ball > 0) {
			stringBuilder.append(ball).append(BALL.getString());
		}
		if (strike > 0) {
			if (ball > 0)
				stringBuilder.append(' ');
			stringBuilder.append(strike).append(STRIKE.getString());
		}
		if (strike == 0 && ball == 0) {
			stringBuilder.append(NOTHING.getString());
		}
		return stringBuilder.toString();
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getBall() {
		return ball;
	}

	public int getStrike() {
		return strike;
	}
}
