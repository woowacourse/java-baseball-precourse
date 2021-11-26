package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Player {
	private int[] answerNumbers;
	private Boolean selectPlayMoreGame;

	public int[] receiveAnswerNumbers(List<Integer> inputList) {
		answerNumbers = Arrays.stream(inputList.toArray(new Integer[inputList.size()]))
			.mapToInt(number -> number)
			.toArray();
		return answerNumbers;
	}

	public void receiveSelectPlayMoreGame(Boolean selectPlayMoreGame) {
		this.selectPlayMoreGame = selectPlayMoreGame;
	}

	public Boolean getSelectPlayMoreGame() {
		return selectPlayMoreGame;
	}

	public void doNotPlayMoreGame() {
		this.selectPlayMoreGame = Boolean.FALSE;
	}

}
