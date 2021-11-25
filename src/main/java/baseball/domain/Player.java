package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Player {
	private int[] answerNumbers;

	public int[] receiveAnswerNumbers(List<Integer> inputList) {
		answerNumbers = Arrays.stream(inputList.toArray(new Integer[inputList.size()]))
			.mapToInt(number -> number)
			.toArray();
		return answerNumbers;
	}
}
