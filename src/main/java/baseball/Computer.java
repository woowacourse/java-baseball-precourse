package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static constants.GameConstant.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Computer {
	private List<Integer> targetNumber;

	public void makeTargetNumber() {
		Set<Integer> numbers = new LinkedHashSet<>();
		while (numbers.size() < NUMBER_LENGTH) {
			numbers.add(pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
		}
		targetNumber = new ArrayList<>(numbers);
	}

	public boolean isNotThreeStrike(List<Integer> playerNumber) {
		return !targetNumber.equals(playerNumber);
	}

	public void checkScore(List<Integer> playerNumber) {
		int strikes = countStrike(playerNumber);
		int balls = countBall(playerNumber);
		System.out.println(getScoreMessage(balls, strikes));
	}

	private int countStrike(List<Integer> playerNumber) {
		return (int)IntStream.range(0, NUMBER_LENGTH)
			.filter(index -> targetNumber.get(index).equals(playerNumber.get(index)))
			.count();
	}

	private int countBall(List<Integer> playerNumber) {
		return (int)playerNumber.stream()
			.filter(targetNumber::contains)
			.filter(number -> targetNumber.indexOf(number) != playerNumber.indexOf(number))
			.count();
	}

	private String getScoreMessage(int balls, int strikes) {
		if (isZeroScore(balls, strikes)) {
			return NOTHING_MESSAGE;
		}
		String ballMessage = getBallOrStrikeMessage(balls, BALL_MESSAGE);
		String strikeMessage = getBallOrStrikeMessage(strikes, STRIKE_MESSAGE);
		String scoreMessage = ballMessage + strikeMessage;
		return scoreMessage;
	}

	private Boolean isZeroScore(int balls, int strikes) {
		return balls + strikes == MIN_COUNT;
	}

	private String getBallOrStrikeMessage(int ballOrStrike, String ballOrStrikeMessage) {
		if (ballOrStrike > MIN_COUNT) {
			return String.format("%d%s ", ballOrStrike, ballOrStrikeMessage);
		}
		return "";
	}
}
