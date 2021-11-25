package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

/** 야구 게임의 전체적인 흐름을 구성 */
public class BaseBallGame {
	private static List<Integer> randomNumber;
	private static Integer continueOrNot;
	private static Integer strike;
	private static Integer ball;

	public static void start() {
		getRandomNumber();
		BaseBallPlayer baseBallPlayer = new BaseBallPlayer();
		baseBallPlayer.getUserNumber();
	}

	private static void getRandomNumber() {
		randomNumber = Randoms.pickUniqueNumbersInRange(1, 9, 3);
	}

}
