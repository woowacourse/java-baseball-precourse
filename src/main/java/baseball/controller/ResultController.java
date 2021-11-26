package baseball.controller;

import java.util.List;

import baseball.domain.AnswerNumber;
import baseball.domain.GameResult;

public class ResultController {
	private int strike;
	private int ball;
	private List<Integer> answerNumberList;
	private List<Integer> inputNumberList;

	public ResultController() {
		strike = 0;
		ball = 0;
		answerNumberList = AnswerNumber.getAnswer();
	}

	public void setResult(List<Integer> inputNumberList) {
		this.inputNumberList = inputNumberList;
		compareAnswerWithInput();
		GameResult.setResultMsg(strike, ball);
	}

	private void compareAnswerWithInput() {
		for (int i = 0; i < AnswerNumber.ANSWER_LENGTH; i++) {
			int answerDigit = answerNumberList.indexOf(i);
			int inputDigit = inputNumberList.indexOf(i);

			if (answerDigit == inputDigit) {
				strike++;
			} else if (answerNumberList.contains(inputDigit)) {
				ball++;
			}
		}
	}

	public boolean isGameCompleted() {
		return strike == AnswerNumber.ANSWER_LENGTH)
	}
}
