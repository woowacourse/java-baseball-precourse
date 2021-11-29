package baseball;

public class Referee {
	private String computer;

	public Referee(String computer) {
		this.computer = computer;
	}

	private void checkBallCount(String inputBallNumber) {
		int ball = 0;
		int strike = 0;
		for (int i = 0; i < inputBallNumber.length(); i++) {
			if (computer.charAt(i) == inputBallNumber.charAt(i)) {
				strike++;
				continue;
			}

			if (computer.contains(inputBallNumber.substring(i, i + 1))) {
				ball++;
			}
		}
	}
}
