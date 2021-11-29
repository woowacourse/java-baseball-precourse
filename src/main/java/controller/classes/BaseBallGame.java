package controller.classes;

import static model.constants.ConstantsForGame.*;

import controller.GameUI;
import model.GameDataInterface;
import model.classes.GameData;

public class BaseBallGame implements GameUI {
	private GameDataInterface gameDataInterface;
	private BaseBallAnswer baseBallAnswer;
	public BaseBallGame() {
		gameDataInterface = new GameData();
	}

	@Override
	public void startGame() {
		while (true) {
			receiveUserAnswer();
			printResult();
		}
	}

	private void receiveUserAnswer() {
		System.out.print(ASKING_STATEMENT);
		gameDataInterface.inputUserAnswer();
	}
	private void printResult() {
	}
	private void refreshGame() {
		//gameDataInterface.setAnswerOfComputer();
	}
}
