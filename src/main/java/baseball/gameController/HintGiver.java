package baseball.gameController;

import java.util.HashSet;
import java.util.Iterator;

public class HintGiver {
	private static final String ball = "볼";
	private static final String strike = "스트라이크";
	private int ballCount = 0;
	private int strikeCount = 0;
	String hint = "";

	public void initHint() {
		this.ballCount = 0;
		this.strikeCount = 0;
		this.hint = "";
	}

	private void checkStrike(HashSet<Integer> realAnswer, int[] playerAnswer) {
		Iterator<Integer> iterator = realAnswer.iterator();
		for (int answer : playerAnswer) {
			if (iterator.next() == answer) {
				this.strikeCount++;
			}
		}
	}

	private void checkBall(HashSet<Integer> realAnswer, int[] playerAnswer) {
		for (int p : playerAnswer) {
			if (realAnswer.contains(p)) {
				this.ballCount++;
			}
		}
		this.ballCount -= this.strikeCount;
	}

	public void setScore(HashSet<Integer> realAnswer, int input) {
		initHint();
		int[] playerAnswer = splitInt(input);
		checkStrike(realAnswer, playerAnswer);
		if (this.strikeCount < 2) {
			checkBall(realAnswer, playerAnswer);
		}
		setHint();
	}

	public void setHint() {
		if (this.ballCount + this.strikeCount == 0) {
			hint += "낫싱";
			return;
		}
		if (this.ballCount > 0) {
			hint += ballCount + ball + " ";
		}
		if (this.strikeCount > 0) {
			hint += strikeCount + strike;
		}
	}

	public void getHint() {
		System.out.println(hint);
	}

	public static int[] splitInt(int input) {
		return new int[] {input / 100, input % 100 / 10, input % 10};
	}
}
