package model.classes;

import static camp.nextstep.edu.missionutils.Console.*;

import exceptions.NumberInputExceptions;
import model.GameDataInterface;
import model.constants.GameMode;

public class GameData implements GameDataInterface {
	private String answerOfUserInput;
	private GameMode gameMode = GameMode.progressing;

	@Override
	public GameMode getGameMode() {
		return gameMode;
	}

	@Override
	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}

	@Override
	public void inputUserAnswer() {
		answerOfUserInput = readLine();
		if (answerOfUserInput.length() != 3) {
			throw new NumberInputExceptions();
		}
	}

	@Override
	public void setGameMode() {
		String userInput = readLine();
		int userInputGameMode = Integer.parseInt(userInput);
		gameMode = defineGameModeFromInteger(userInputGameMode);
	}

	@Override
	public String getAnswerOfUserInput() {
		return answerOfUserInput;
	}

	private GameMode defineGameModeFromInteger(int integer) {
		if (integer == 1) {
			return GameMode.restart;
		} else if (integer == 2) {
			return GameMode.ending;
		} else {
			throw new NumberInputExceptions();
		}
	}
}
