package baseball;

import java.util.ArrayList;

public class Result {
	private int strike;
	private int ball;
	private String message;

	public void addStrikeCount() {
		this.strike++;
	}

	public void addBallCount() {
		this.ball++;
	}

	public void createMessage() {
		if (this.strike == 0 && this.ball == 0) {
			this.message = "낫싱";
			return;
		}

		ArrayList<String> list = new ArrayList<>();
		if (this.ball != 0) {
			list.add(this.ball + "볼");
		}

		if (this.strike != 0) {
			list.add(this.strike + "스트라이크");
		}

		this.message = String.join(" ", list);
	}

	public void printMessage() {
		System.out.println(message);
	}

	public boolean isFinish(int numberLength) {
		return numberLength == this.strike;
	}
}
