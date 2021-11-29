package baseball;

import baseball.gamecontroller.GameDriver;

public class Application {

	public static void main(String[] args) {
		GameDriver gameDriver = new GameDriver();
		gameDriver.run();
	}
}