package baseball;

import static baseball.constants.GameConstants.GameOverInput.*;

import java.util.ArrayList;

import baseball.builder.RandomDigitsBuilder;
import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.Player;
import baseball.domain.UserGameSelection;

public class Application {
	public static void main(String[] args) {
		runGameLoop();
	}

	private static void runGameLoop() {
		Computer computer = new Computer(RandomDigitsBuilder.getRandomDigitList());
		Player player = new Player();
		UserGameSelection userGameSelection = new UserGameSelection(RESTART);
		Game game = new Game(computer, player, userGameSelection);
		while (true) {
			game.runGameOnce();
			if (userGameSelection.getUserGameSelection() == RESTART) {
				computer.setNumberList(RandomDigitsBuilder.getRandomDigitList());
				continue;
			}
			if (userGameSelection.getUserGameSelection() == STOP)
				break;
		}
	}
}
