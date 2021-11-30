package baseball;

import java.util.ArrayList;

public class Result {
	private int strikeCount;
	private int ballCount;
	private int nothing;
	private String resultText;
	private boolean exit;

	protected Result() {
		this.strikeCount = 0;
		this.ballCount = 0;
		this.nothing = 0;
		this.resultText = "";
		this.exit = false;
	}

	private void initScore() {
		this.strikeCount = 0;
		this.ballCount = 0;
		this.nothing = 0;
	}

	protected void compareNum(ArrayList<Integer> computerNum, ArrayList<Integer> userNum) {
		initScore();
		for(int i = 0; i < userNum.size(); i++) {
			validateNum(userNum.get(i), i, computerNum);
		}
		if (strikeCount == 3) {
			exit = true;
		} else {
			exit = false;
		}
	}

	private void validateNum(int userNum, int userNumIndex, ArrayList<Integer> computerNum) {
		if(computerNum.contains(userNum)) {
			if (computerNum.indexOf(userNum) == userNumIndex) {
				strikeCount++;
			} else {
				ballCount++;
			}
		} else {
			nothing++;
		}
	}

	protected void printResult() {
		if (strikeCount == 3) {
			resultText = "3스트라이크\n";
			resultText += "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
		} else if (nothing == 3) {
			resultText = "낫싱";
		} else if (strikeCount == 0) {
			resultText = ballCount + "볼";
		} else if (ballCount == 0) {
			resultText = strikeCount + "스트라이크";
		} else {
			resultText = ballCount + "볼 " + strikeCount + "스트라이크";
		}
		System.out.println(resultText);
	}

	protected boolean getExit() {
		return exit;
	}
}
