package baseball.domain;

import java.util.List;

public class NumberBaseballGame {
	private static final Integer BASEBALL_GAME_BALL_COUNT = 3;
	private static final Integer BASEBALL_GAME_NUMBER_RANGE_START = 1;
	private static final Integer BASEBALL_GAME_NUMBER_RANGE_END = 9;
	private static final String WRONG_LENGTH_INPUT = "입력할 숫자는 3자리만 가능합니다.";
	private static final String WRONG_RANGE_INPUT = "입력할 숫자는 1~9 사이만 가능합니다.";
	private static final String DUPLICATE_INPUT = "입력할 숫자는 서로 달라야 합니다.";
	private static final String PLAY_MORE_GAME = "1";
	private static final String DO_NOT_PLAY_MORE_GAME = "2";
	private static final String WRONG_INPUT_SELECT_PLAY_MORE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력해야만 합니다.";

	private List<Integer> inputList;
	private Boolean gameState;

	public void validateInputNumber(List<Integer> inputList) {
		this.inputList = inputList;
		validateLength();
		validateRange();
		validateDuplication();
	}

	private void validateLength() {
		if (inputList.size() != BASEBALL_GAME_BALL_COUNT) {
			throw new IllegalArgumentException(WRONG_LENGTH_INPUT);
		}
	}

	private void validateRange() {
		Boolean validateRangeResult = inputList.stream()
			.allMatch(number -> BASEBALL_GAME_NUMBER_RANGE_START <= number && number <= BASEBALL_GAME_NUMBER_RANGE_END);
		if (!validateRangeResult) {
			throw new IllegalArgumentException(WRONG_RANGE_INPUT);
		}
	}

	private void validateDuplication() {
		Boolean validateDuplicationResult = inputList.stream()
			.distinct()
			.count() != inputList.size();
		if (validateDuplicationResult) {
			throw new IllegalArgumentException(DUPLICATE_INPUT);
		}
	}

	public Boolean getGameState() {
		return this.gameState;
	}

	public void startGame() {
		this.gameState = Boolean.TRUE;
	}

	public void closeGame() {
		this.gameState = Boolean.FALSE;
	}

	public Boolean validateSelectPlayMoreGame(String inputResultOfSelectPlayMoreGame) {
		if (inputResultOfSelectPlayMoreGame.equals(PLAY_MORE_GAME)) {
			return Boolean.TRUE;
		}
		if (inputResultOfSelectPlayMoreGame.equals(DO_NOT_PLAY_MORE_GAME)) {
			return Boolean.FALSE;
		}
		throw new IllegalArgumentException(WRONG_INPUT_SELECT_PLAY_MORE_GAME);
	}
}
