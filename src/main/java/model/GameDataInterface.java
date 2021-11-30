package model;

import model.constants.GameMode;

public interface GameDataInterface {
	void inputUserAnswer();

	void setGameMode();

	String getAnswerOfUserInput();

	GameMode getGameMode();

	void setGameMode(GameMode gameMode);
}
