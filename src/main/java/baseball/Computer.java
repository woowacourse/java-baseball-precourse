package baseball;

import java.util.List;

public class Computer {
	Result result = new Result();
	Answer answer = new Answer();

	public boolean matchAnswer(List<Integer> gameReply) {
		return result.matchAnswer(answer.getAnswer(), gameReply);
	}

	public void printResult() {
		result.printResult();
	}

	public void setNewGame() {
		answer.makeAnswer();
	}
}
