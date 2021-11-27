package baseball;

import java.util.List;

// 정답 생성과 매칭을 도와주는 컴퓨터 class
public class Computer {
	private final Result result;
	private final Answer answer;

	public Computer() {
		this.result = new Result();
		this.answer = new Answer();
	}

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
