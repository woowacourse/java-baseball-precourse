package baseball;

import static utils.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import utils.GameStatus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

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
		setGameStatusToPlaying();

		while (gameStatus == GameStatus.PALYING) {
			makeAnswerNumber();
			play();
			requestRestartOrFinishInput();
		}
	}

	private void play() {
		while (true) {
			initializeRound();
			makeInputNumber();
			calculateScore();
			printScore();
			if (isAnswer()) {
				OutputView.printAnswerMessage();
				return;
			}
		}
	}

	private void setGameStatusToPlaying() {
		gameStatus = GameStatus.PALYING;
	}

	private void initializeRound() {
		inputNumberList.clear();
		score.initializeScore();
	}

	private void makeInputNumber() {
		String inputNumberString = InputView.getInputNumber();
		if (!isValidInputNumber(inputNumberString)) {
			throw new IllegalArgumentException();
		}
		inputNumberList = getIntegerArrayListFromString(inputNumberString);
	}

	private void makeAnswerNumber() {
		answerNumberList.clear();
		LinkedHashSet<Integer> tmp = new LinkedHashSet<>();
		while (tmp.size() < GAME_NUMBER_LENGTH) {
			int randomNum = Randoms.pickNumberInRange(1, 9);
			tmp.add(randomNum);
		}

		for (int num : tmp) {
			answerNumberList.add(num);
		}
	}

	private boolean isValidInputNumber(String str) {
		if (str.length() != GAME_NUMBER_LENGTH) {
			return false;
		}
		if (str.contains("0")) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}

		Set<Character> s = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			s.add(str.charAt(i));
		}
		if (s.size() != GAME_NUMBER_LENGTH) {
			return false;
		}

		return true;
	}

	private ArrayList<Integer> getIntegerArrayListFromString(String str) {
		ArrayList<Integer> tmp = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			int num = Character.getNumericValue(str.charAt(i));
			tmp.add(num);
		}
		return tmp;
	}

	private void calculateScore() {
		for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
			if (answerNumberList.get(i).equals(inputNumberList.get(i))) {
				score.addStrike();
				continue;
			}
			if (answerNumberList.contains(inputNumberList.get(i))) {
				score.addBall();
			}
		}
	}

	private boolean isAnswer() {
		for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
			if (!answerNumberList.get(i).equals(inputNumberList.get(i))) {
				return false;
			}
		}
		return true;
	}

	private void printScore() {
		String scoreString = score.getScoreToString();
		OutputView.printGameScore(scoreString);
	}

	private void requestRestartOrFinishInput() {
		String str = InputView.getRestartOrFinishCommand();

		if (str.equals(FINISH_COMMAND)) {
			gameStatus = GameStatus.FINISHED;
		}
		if (str.equals(RESTART_COMMAND)) {
			gameStatus = GameStatus.PALYING;
		}
	}
}