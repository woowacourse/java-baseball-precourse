package baseball;

import baseball.gameController.GameDriver;

public class Application {

	public static void main(String[] args) {
		GameDriver gameDriver = new GameDriver();
		gameDriver.run();
	}
}