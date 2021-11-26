package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static util.GameConstant.*;

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

	public void checkBallAndStrike(List<Integer> playerNumber) {
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
		String ballAndStrikeMessage = ballMessage + strikeMessage;
		if (ballAndStrikeMessage.equals("")) {
			return NOTHING_MESSAGE;
		}
		return ballAndStrikeMessage;
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
}
