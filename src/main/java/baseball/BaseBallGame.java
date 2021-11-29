package baseball;

import static utils.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import utils.GameStatus;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class BaseBallGame {

	private ArrayList<Integer> answerNumberList;
	private ArrayList<Integer> inputNumberList;
	private Score score;
	private GameStatus gameStatus;

	public BaseBallGame() {
		answerNumberList = new ArrayList<>();
		inputNumberList = new ArrayList<>();
		score = new Score();
		gameStatus = GameStatus.READY;
	}

	public void start() {
		setGameStatus(PLAY_COMMAND);

		while (gameStatus == GameStatus.PALYING) {
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
			inputNumberList = getIntegerArrayListFromString(inputNumberString);

			String scoreString = score.getScoreOfNumbers(answerNumberList, inputNumberList);
			OutputView.printGameScore(scoreString);
			if (scoreString.equals(THREE_STRIKE)) {
				OutputView.printAnswerMessage();
				return;
			}
		}
	}

	private ArrayList<Integer> getIntegerArrayListFromString(String str) {
		ArrayList<Integer> tmp = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			int num = Character.getNumericValue(str.charAt(i));
			tmp.add(num);
		}
		return tmp;
	}

	private void setGameStatus(String command) {
		if (command.equals(PLAY_COMMAND)) {
			gameStatus = GameStatus.PALYING;
		}
		if (command.equals(FINISH_COMMAND)) {
			gameStatus = GameStatus.FINISHED;
		}
		if (command.equals(RESTART_COMMAND)) {
			gameStatus = GameStatus.PALYING;
		}
	}

	private void initializeRound() {
		inputNumberList.clear();
		score.initializeScore();
	}

	private void makeAnswerNumber() {
		answerNumberList.clear();
		LinkedHashSet<Integer> tmp = new LinkedHashSet<>();
		while (tmp.size() < GAME_NUMBER_LENGTH) {
			int randomNum = Randoms.pickNumberInRange(MIN_GAME_NUMBER, MAX_GAME_NUMBER);
			tmp.add(randomNum);
		}
		answerNumberList.addAll(tmp);
	}

}