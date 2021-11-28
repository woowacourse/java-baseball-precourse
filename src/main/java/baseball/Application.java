package baseball;

import baseball.game.service.GameProgress;
import baseball.game.service.NumberCreation;

public class Application {
	public static void main(String[] args) {
		boolean keepPlay = true;
		while (keepPlay) {
			int[] answerArr = NumberCreation.createRandomNumber();
			keepPlay = GameProgress.startGame(answerArr);
		}
	}

}
