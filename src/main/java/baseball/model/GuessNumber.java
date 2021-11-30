package baseball.model;

public class GuessNumber {
	private int idx;
	private int val;
	private String result;

	public GuessNumber(int idx, int val, String result) {
		this.idx = idx;
		this.val = val;
		this.result = result;
	}

	public boolean isStrike() {
		return result.equals("STRIKE");
	}

	public boolean isBall() {
		return result.equals("BALL");
	}

}