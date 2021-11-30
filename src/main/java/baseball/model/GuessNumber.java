package baseball.model;

public class GuessNumber {
	private int idx;
	private int val;

	public GuessNumber(int idx, int val) {
		this.idx = idx;
		this.val = val;
	}

	public boolean isStrike(Answer answer) {
		return answer.contains(val) && answer.indexOf(val) == idx;
	}

	public boolean isBall(Answer answer) {
		return answer.contains(val) && answer.indexOf(val) != idx;
	}

}