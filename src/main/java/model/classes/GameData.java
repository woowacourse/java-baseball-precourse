package model.classes;

import static camp.nextstep.edu.missionutils.Console.*;

import model.GameDataInterface;
import model.constants.GameMode;

public class GameData implements GameDataInterface {
	private String answerOfUserInput;
	private GameMode gameMode = GameMode.progressing;

	@Override
	public void inputUserAnswer() {
		answerOfUserInput = readLine();
	}

	@Override
	public void setGameMode() {
		String userInput = readLine();
		int userInputGameMode = Integer.parseInt(userInput);
		gameMode = defineGameModeFromInteger(userInputGameMode);
	}

	private GameMode defineGameModeFromInteger(int integer) {
		try {
			if(integer == 1) {
				return GameMode.progressing;
			} else if(integer == 2) {
				return GameMode.ending;
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException error) {
			System.out.println("예외가 발생했습니다.");
			return GameMode.ending;
		}
	}
}
