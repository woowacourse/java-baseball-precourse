package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Player {
	private static final String PLAY_MORE_GAME = "1";
	private static final String DO_NOT_PLAY_MORE_GAME = "2";
	private static final String WRONG_INPUT_SELECT_PLAY_MORE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력해야만 합니다.";

	private int[] answerNumbers;
	private Boolean playMoreGame;

	public int[] receiveAnswerNumbers(List<Integer> inputList) {
		answerNumbers = Arrays.stream(inputList.toArray(new Integer[inputList.size()]))
			.mapToInt(number -> number)
			.toArray();
		return answerNumbers;
	}

	public void receivePlayMoreGame(String responsePlayMoreGame) {
		Boolean playMoreGame = validatePlayMoreGame(responsePlayMoreGame);
		this.playMoreGame = playMoreGame;
	}

	private Boolean validatePlayMoreGame(String responsePlayMoreGame) {
		if (responsePlayMoreGame.equals(PLAY_MORE_GAME)) {
			return Boolean.TRUE;
		}
		if (responsePlayMoreGame.equals(DO_NOT_PLAY_MORE_GAME)) {
			return Boolean.FALSE;
		}
		throw new IllegalArgumentException(WRONG_INPUT_SELECT_PLAY_MORE_GAME);
	}

	public Boolean getPlayMoreGame() {
		return playMoreGame;
	}

}
