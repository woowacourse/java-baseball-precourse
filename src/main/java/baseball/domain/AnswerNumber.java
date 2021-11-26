package baseball.domain;

import java.util.List;

public class AnswerNumber {
	private static List<Integer> answer;
	public static final int ANSWER_LENGTH = 3;
	public static final int ANSWER_MIN_VALUE = 1;
	public static final int ANSWER_MAX_VALUE = 9;

	public static void setAnswer(List<Integer> numberList) {
		answer = numberList;
	}

	public static List<Integer> getAnswer() {
		return answer;
	}
}
