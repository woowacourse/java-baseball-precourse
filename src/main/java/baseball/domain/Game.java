package baseball.domain;

import static baseball.constants.GameConstants.Terminology.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Game {

	private Computer computer;
	private Player player;
	private int ball, strike;

	public Game() {
		resetGameResult();
	}

	private void resetGameResult() {
		this.ball = 0;
		this.strike = 0;
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
		if (strike > 0) {
			stringBuilder.append(strike).append(STRIKE.getString());
		}
		if (ball > 0) {
			if (strike > 0)
				stringBuilder.append(' ');
			stringBuilder.append(ball).append(BALL.getString());
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
