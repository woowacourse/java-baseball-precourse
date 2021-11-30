package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.Arrays;

import controller.classes.BaseBallGame;
import view.GameConsole;
import view.classes.Game;

public class Application {
	public static void main(String[] args) {
		GameConsole gameConsole = new Game();
		gameConsole.gameStart();

	}
}