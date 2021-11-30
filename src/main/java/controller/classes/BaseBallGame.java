package controller.classes;

import static model.constants.ConstantsForGame.*;

import controller.GameUI;
import model.GameDataInterface;
import model.classes.CountingStatus;
import model.classes.GameData;
import model.constants.GameMode;
import model.constants.StrikeStatus;

public class BaseBallGame implements GameUI {
	private GameDataInterface gameDataInterface;
	private BaseBallAnswer baseBallAnswer;
	private CountingStatus currentCount;

	public BaseBallGame() {
		gameDataInterface = new GameData();
	}

	@Override
	public void startGame() {
		baseBallAnswer = new BaseBallAnswer();
		baseBallAnswer.makeAnswer();
		while (gameDataInterface.getGameMode() != GameMode.ending) {
			if (gameDataInterface.getGameMode() == GameMode.restart) {
				refreshGame();
			}
			if (gameDataInterface.getGameMode() == GameMode.progressing) {
				receiveUserAnswer();
				setCurrentCount(baseBallAnswer.calculateStatus(gameDataInterface.getAnswerOfUserInput()));
				printResult();
			}
			if (gameDataInterface.getGameMode() == GameMode.askingMode) {
				printEndMessage();
				receiveUserMode();
				continue;
			}
			setGameState();
		}
	}

	private void receiveUserAnswer() {
		System.out.print(ASKING_STATEMENT);
		gameDataInterface.inputUserAnswer();
	}

	private void receiveUserMode() {
		System.out.println(ASKING_GAME_MODE_STATEMENT);
		gameDataInterface.setGameMode();
	}

	private void printResult() {
		System.out.println(currentCount);
	}

	private void printEndMessage() {
		System.out.println(ENDING_STATEMENT);
	}

	private void refreshGame() {
		currentCount = new CountingStatus();
		baseBallAnswer.cleanAnswerArray();
		baseBallAnswer.makeAnswer();
		gameDataInterface.setGameMode(GameMode.progressing);
	}

	private void setCurrentCount(CountingStatus countingStatus) {
		currentCount = countingStatus;
	}

	private void setGameState() {
		if (currentCount.getStrikeStatus() == StrikeStatus.three) {
			gameDataInterface.setGameMode(GameMode.askingMode);
		}
	}
}
