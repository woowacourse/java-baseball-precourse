package baseball;

import view.GameConsole;
import view.classes.Game;

public class Application {
	public static void main(String[] args) {
		GameConsole gameConsole = new Game();
		gameConsole.gameStart();
	}
}