package baseball.domain;

public class Player {
	private static Player instance = new Player();
	private int[] tryNumber = new int[3];

	private Player() {
	}

	public static Player getInstance() {
		if (instance == null) {
			return new Player();
		}
		return instance;
	}

	public int[] submitTryNumber() {
		return tryNumber;
	}

	public void playerInput(String playerInput) {
		String[] input = playerInput.split("");
		for (int i = 0; i < input.length; i++) {
			tryNumber[i] = Integer.parseInt(input[i]);
		}
	}
}
