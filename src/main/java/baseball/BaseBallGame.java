package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static util.GameConstant.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class BaseBallGame {
	private final Player player;
	private List<Integer> targetNumber;

	public BaseBallGame() {
		player = new Player();
		startGame();
	}

	private void startGame() {
		targetNumber = getTargetNumber();
		playGame();
		checkReplaying();
	}

	private List<Integer> getTargetNumber() {
		Set<Integer> result = new LinkedHashSet<>();
		while (result.size() < NUMBER_LENGTH) {
			result.add(pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
		}
		return new ArrayList<>(result);
	}

	private void playGame() {
		List<Integer> playerNumber = player.getPlayerNumber();
		while (!isThreeStrike(playerNumber)) {
			checkBallAndStrike(playerNumber);
			playerNumber = player.getPlayerNumber();
		}
		printClearMessage();
	}

	private boolean isThreeStrike(List<Integer> playerNumber) {
		return targetNumber.equals(playerNumber);
	}

	private void printClearMessage() {
		System.out.println(NUMBER_LENGTH + STRIKE_MESSAGE);
		System.out.println(GAME_CLEAR_MESSAGE);
		System.out.println(REPLAYING_OR_END_MESSAGE);
	}

	private void checkBallAndStrike(List<Integer> playerNumber) {
		int strikes = countStrike(playerNumber);
		int balls = countBall(playerNumber, strikes);
		System.out.println(getBallAndStrikeMessage(balls, strikes));
	}

	private int countStrike(List<Integer> playerNumber) {
		return (int)IntStream.range(0, NUMBER_LENGTH)
			.filter(index -> targetNumber.get(index).equals(playerNumber.get(index)))
			.count();
	}

	private int countBall(List<Integer> playerNumber, int strikes) {
		return (int)playerNumber.stream()
			.filter(targetNumber::contains)
			.count() - strikes;
	}

	private String getBallAndStrikeMessage(int balls, int strikes) {
		String ballMessage = getBallMessage(balls);
		String strikeMessage = getStrikeMessage(strikes);
		String result = ballMessage + strikeMessage;
		if (result.equals("")) {
			return NOTHING_MESSAGE;
		}
		return result;
	}

	private String getBallMessage(int balls) {
		if (balls > MIN_COUNT) {
			return String.format("%d%s ", balls, BALL_MESSAGE);
		}
		return "";
	}

	private String getStrikeMessage(int strikes) {
		if (strikes > MIN_COUNT) {
			return String.format("%d%s", strikes, STRIKE_MESSAGE);
		}
		return "";
	}

	private void checkReplaying() {
		int replayingOrEndNumber = player.getReplayingOrEndNumber();
		if (replayingOrEndNumber == REPLAYING_NUMBER) {
			startGame();
		}
	}
}
