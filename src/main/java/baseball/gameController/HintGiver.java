package baseball.gameController;

import java.util.HashSet;
import java.util.Iterator;

public class HintGiver {
	String ball = "볼";
	String strike = "스트라이크";
	int ballCount = 0;
	int strikeCount = 0;

	private void checkStrike(HashSet<Integer> realAnswer, int[] playerAnswer) {
		Iterator<Integer> iterator = realAnswer.iterator();
		// int num = 0;
		for (int answer : playerAnswer) {
			if (iterator.next() == answer) {
				this.strikeCount++;
			}
		}
	}

	private void checkBall(HashSet<Integer> realAnswer, int[] playerAnswer) {
		Iterator<Integer> iterator = realAnswer.iterator();
		for (int p : playerAnswer) {
			if (realAnswer.contains(p)) {
				this.ballCount++;
			}
		}
		this.ballCount -= this.strikeCount;
	}

	public void setScore(HashSet<Integer> realAnswer, int[] playerAnswer) {
		checkStrike(realAnswer, playerAnswer);
		if (this.strikeCount < 2) {
			checkBall(realAnswer, playerAnswer);
		}
	}

	public void getHint() {
		if (this.ballCount + this.strikeCount == 0) {
			System.out.println("낫싱");
			return;
		}
		if (this.ballCount > 0) {
			System.out.print(ballCount + ball + " ");
		}
		if (this.strikeCount > 0) {
			System.out.println(strikeCount + strike);
		}
	}
}
