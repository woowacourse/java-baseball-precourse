package baseball;

import static util.GameConstant.*;

import java.util.List;

public class BaseballGame {
	private final Player player;
	private final Computer computer;

	public BaseballGame() {
		player = new Player();
		computer = new Computer();
	}

	public void startGame() {
		computer.makeTargetNumber();
		playGame();
		checkReplaying();
	}

	private void playGame() {
		List<Integer> playerNumber = player.getPlayerNumber();
		while (computer.isNotThreeStrike(playerNumber)) {
			computer.checkBallAndStrike(playerNumber);
			playerNumber = player.getPlayerNumber();
		}
		printClearMessage();
	}

	private void printClearMessage() {
		System.out.println(NUMBER_LENGTH + STRIKE_MESSAGE);
		System.out.println(GAME_CLEAR_MESSAGE);
		System.out.println(REPLAYING_OR_END_MESSAGE);
	}

	private void checkReplaying() {
		int replayingOrEndNumber = player.getReplayingOrEndNumber();
		if (replayingOrEndNumber == REPLAYING_NUMBER) {
			startGame();
		}
	}
}
