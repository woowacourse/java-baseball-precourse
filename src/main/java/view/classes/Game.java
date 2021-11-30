package view.classes;

import controller.classes.BaseBallGame;
import view.GameConsole;

public class Game implements GameConsole {

	@Override
	public void gameStart() {
		BaseBallGame baseBallGame = new BaseBallGame();
		baseBallGame.startGame();
	}
}
