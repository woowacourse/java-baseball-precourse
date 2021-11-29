package controller.classes;

import static model.constants.ConstantsForGame.*;

import controller.GameUI;
import model.GameDataInterface;
import model.classes.CountingStatus;
import model.classes.GameData;

public class BaseBallGame implements GameUI {
	private GameDataInterface gameDataInterface;
	private BaseBallAnswer baseBallAnswer = new BaseBallAnswer();
	private CountingStatus currentCount;
	public BaseBallGame() {
		gameDataInterface = new GameData();
	}

	@Override
	public void startGame() {
		baseBallAnswer.makeAnswer();
		while (true) {
			receiveUserAnswer();
			setCurrentCount(baseBallAnswer.calculateStatus(gameDataInterface.getAnswerOfUserInput()));
			printResult();
		}
	}

	private void receiveUserAnswer() {
		System.out.print(ASKING_STATEMENT);
		gameDataInterface.inputUserAnswer();
	}
	private void printResult() {
		System.out.println(currentCount);
	}
	private void refreshGame() {
		//gameDataInterface.setAnswerOfComputer();
	}
	private void setCurrentCount(CountingStatus countingStatus) {
		currentCount = countingStatus;
	}
}
