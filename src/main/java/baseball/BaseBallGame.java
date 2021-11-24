package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

/** 야구 게임의 전체적인 흐름을 구성 */
public class BaseBallGame {
	private static String userNumber;
	private static List<Integer> randomNumber;
	private static Integer continueOrNot;
	private static Integer strike;
	private static Integer ball;

	public static void start() {
		getRandomNumber();
		getUserNumber();
		System.out.println(randomNumber);
		System.out.println(userNumber);
	}

	private static void getRandomNumber() {
		randomNumber = Randoms.pickUniqueNumbersInRange(1, 9, 3);
	}

	public static void getUserNumber() {
		userNumber = Console.readLine();
	}
}
