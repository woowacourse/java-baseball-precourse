package baseball;

public class Judge {

	private String rightAnswer;
	private int numberOfStrikes;
	private int numberOfBalls;
	private boolean gameSuccess;

	Judge() {
		numberOfStrikes = 0;
		numberOfBalls = 0;
		gameSuccess = false;
	}

	public int getStrike() {
		return numberOfStrikes;
	}

	public int getBall() {
		return numberOfBalls;
	}

	public boolean getGameSuccess() {
		return gameSuccess;
	}

	public void initialize() {
		numberOfBalls = 0;
		numberOfStrikes = 0;
	}

	public void setRightAnswer(final String threeDigitNum) {
		rightAnswer = threeDigitNum;
	}

	private boolean isBall(final int indexOfNum, final String targetNum) {
		char curChar = targetNum.charAt(indexOfNum);
        return curChar == rightAnswer.charAt((indexOfNum + 1) % 3) || curChar == rightAnswer.charAt((indexOfNum + 2) % 3);
    }

	public void makeJudgement(final String target) {
		for (int i = 0; i < 3; i++) {
			char curDigit = target.charAt(i);
			if (curDigit == rightAnswer.charAt(i)) {
				numberOfStrikes++;
			}
			if (isBall(i, target)) {
				numberOfBalls++;
			}
			if (numberOfStrikes == 3) {
				gameSuccess = true;
			}
		}
	}
}

