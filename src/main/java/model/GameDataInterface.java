package model;

import model.constants.GameMode;

public interface GameDataInterface {
	void inputUserAnswer();
	void setGameMode();
	void setAnswerOfComputer(String answer);
	String getAnswerOfUserInput();
	GameMode getGameMode();
	void setGameMode(GameMode gameMode);
}
