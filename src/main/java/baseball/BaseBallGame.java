package baseball;

import static utils.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

public class BaseBallGame {
	enum GameStatus {
		READY,
		PLAYING,
		FINISHED
	}

	private int[] answerNumbers;
	private int[] inputNumbers;
	private Score score;
	private GameStatus gameStatus;

	public BaseBallGame() {
		answerNumbers = new int[GAME_NUMBER_LENGTH];
		inputNumbers = new int[GAME_NUMBER_LENGTH];
		score = new Score();
		gameStatus = GameStatus.READY;
	}

	public void start() {
		setGameStatus(PLAY_COMMAND);

		while (gameStatus == GameStatus.PLAYING) {
			makeAnswerNumber();
			play();
			String command = InputView.getRestartOrFinishCommand();
			if (!Validator.checkRestartOrFinishCommand(command)) {
				throw new IllegalArgumentException();
			}
			setGameStatus(command);
		}
	}

	private void play() {
		while (true) {
			initializeRound();

			String inputNumberString = InputView.getInputNumber();
			if (!Validator.checkInputNumber(inputNumberString)) {
				throw new IllegalArgumentException();
			}
			setInputNumberListFromString(inputNumberString);
			String scoreString = score.getScoreOfNumbers(answerNumbers, inputNumbers);
			OutputView.printGameScore(scoreString);
			if (scoreString.equals(THREE_STRIKE)) {
				OutputView.printAnswerMessage();
				return;
			}
		}
	}

	private void setInputNumberListFromString(String str) {
		for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
			inputNumbers[i] = Character.getNumericValue(str.charAt(i));
		}
	}

	private void setGameStatus(String command) {
		if (command.equals(PLAY_COMMAND)) {
			gameStatus = GameStatus.PLAYING;
		}
		if (command.equals(FINISH_COMMAND)) {
			gameStatus = GameStatus.FINISHED;
		}
		if (command.equals(RESTART_COMMAND)) {
			gameStatus = GameStatus.PLAYING;
		}
	}

	private void initializeRound() {
		score.initializeScore();
	}

	private void makeAnswerNumber() {
		LinkedHashSet<Integer> tmp = new LinkedHashSet<>();
		while (tmp.size() < GAME_NUMBER_LENGTH) {
			int randomNum = Randoms.pickNumberInRange(MIN_GAME_NUMBER, MAX_GAME_NUMBER);
			tmp.add(randomNum);
		}
		int idx = 0;
		for (int num : tmp) {
			answerNumbers[idx] = num;
			idx++;
		}
	}

}