package baseball;

import java.util.HashSet;

public class PlayerNumber {
	private static final int NUMBER_OF_DIGIT = 3;

	private String playerNumber;

	public PlayerNumber(String playerNumber) {
		this.playerNumber = playerNumber;
		checkValidity();
	}

	public void checkValidity() {
		if (playerNumber.contains("0")) {
			throw new IllegalArgumentException();
		}
		if (playerNumber.length() != NUMBER_OF_DIGIT) {
			throw new IllegalArgumentException();
		}
		if (isDuplicate()) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isDuplicate() {
		HashSet<Character> digits = new HashSet<Character>();
		for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
			digits.add(playerNumber.charAt(i));
		}
		if (digits.size() != NUMBER_OF_DIGIT) {
			return true;
		} else {
			return false;
		}
	}

	public String getPlayerNumber() {
		return playerNumber;
	}
}
