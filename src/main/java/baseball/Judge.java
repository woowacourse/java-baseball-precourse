package baseball;

public class Judge {
	private static final Judge INSTANCE = new Judge();
	private char[] defendNumber;
	public boolean flag = false;

	private Judge() {}

	public static Judge getInstance() {
		return INSTANCE;
	}

	public void setDefendNumber(int number) {
		defendNumber = getToCharArray("" + number);
		flag = false;
	}

	public String judging(String attackNumber) {
		if (attackNumber.length() != 3 || attackNumber.contains("0")) {
			throw new IllegalArgumentException();
		}

		char[] charArray = getToCharArray(attackNumber);
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < 3; i++) {
			if (defendNumber[i] == charArray[i]) {
				strike++;
			} else if (attackNumber.contains(defendNumber[i] + "")) {
				ball++;
			}
		}

		return printResult(strike, ball);
	}

	private static char[] getToCharArray(String s) {
		return (s).toCharArray();
	}

	private String printResult(int strike, int ball) {
		StringBuilder sb = new StringBuilder();
		if (strike == 3) {
			flag = true;
		}
		if (ball == 0 && strike == 0) {
			sb.append("낫싱");
		} else {
			if (ball > 0) {
				sb.append(ball + "볼 ");
			}
			if (strike > 0) {
				sb.append(strike + "스트라이크");
			}
		}
		return sb.toString();
	}

}
