package baseball;

import baseball.game.service.GameProgress;
import baseball.game.service.NumberCreation;

public class Application {
	public static void main(String[] args) {
		boolean keepPlay = true;
		while (keepPlay) {
			int answer = NumberCreation.createRandomNumber();
			keepPlay = GameProgress.startGame(answer);
		}
	}
	
}
