package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.Arrays;

import controller.classes.BaseBallGame;

public class Application {
	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		//GameDataInterface m = new GameData();
		//m.inputUserAnswer();
		//m.setGameMode();
		BaseBallGame baseBallGame = new BaseBallGame();
		baseBallGame.startGame();
		// System.out.println(pickUniqueNumbersInRange(1,9,3));
		// System.out.println(pickUniqueNumbersInRange(1,9,3));
		// System.out.println(pickUniqueNumbersInRange(1,9,3));
	}
}