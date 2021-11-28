package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import config.Config;

public class Game {

	private static int[] randomAns;
	private Player player = new Player();
	private Config config = new Config();

	public void play() {
		boolean start = true;

		while (start) {
			randomAns = createTargetNum();

			boolean ansCheck = false;
			while (!ansCheck) {
				ansCheck = compareToRandomAns(userInputNum());
			}
			start = checkRestart();
		}
	}

	private int[] createTargetNum() {
		int[] randomAns = new int[3];
		boolean[] check = new boolean[config.getEndNum() + 1];

		for (int i = 0; i < config.getNumLength(); i++) {
			int num = Randoms.pickNumberInRange(config.getBeginNum(), config.getEndNum());

			while (check[num]) {
				num = Randoms.pickNumberInRange(config.getBeginNum(), config.getEndNum());
			}

			check[num] = true;
			randomAns[i] = num;
		}
		return randomAns;
	}

	private int[] userInputNum() {
		System.out.print(config.getEnterNumber());
		String inputStr = Console.readLine();

		return checkUserInputNum(inputStr);
	}

	private int[] checkUserInputNum(String inputStr) {
		int[] userInputNumArr = new int[config.getNumLength()];
		boolean[] checkInputNum = new boolean[config.getEndNum() + 1];

		// 입력 값이 길이가 3미만 3초과일 경우
		if (inputStr.length() < config.getNumLength() || inputStr.length() > config.getNumLength()) {
			throw new IllegalArgumentException();
		}

		// 숫자로 이루어지지 않았을 경우, 0이 포함 되어 있을 경우, 반복된 숫자를 입력하였을 경우
		for (int i = 0; i < config.getNumLength(); i++) {
			int inputNum = inputStr.charAt(i) - '0';

			if (inputStr.charAt(i) == '0' || !Character.isDigit(inputStr.charAt(i))) {
				throw new IllegalArgumentException();
			}

			if (checkInputNum[inputNum]) {
				throw new IllegalArgumentException();
			}

			checkInputNum[inputNum] = true;
			userInputNumArr[i] = inputStr.charAt(i) - '0';
		}

		return userInputNumArr;
	}

	private boolean compareToRandomAns(int[] userInputNumArr) {
		player.init(userInputNumArr);

		for (int i = 0; i < config.getNumLength(); i++) {
			player.compareNum(randomAns[i], i);
		}

		return notifyBallAndStrike(player.getStrike(), player.getBall());
	}

	private boolean notifyBallAndStrike(int strike, int ball) {
		if (strike == 3) {
			System.out.println(config.getNumLength() + config.getSTRIKE());
			System.out.println(config.getEnd_GAME());
			return true;
		}

		if (strike > 0 && ball > 0) {
			System.out.println(ball + config.getBALL() + " " + strike + config.getSTRIKE());
			return false;
		}

		if (strike == 0 && ball == 0) {
			System.out.println(config.getNOTHING());
			return false;
		}

		if (ball == 0) {
			System.out.println(strike + config.getSTRIKE());
			return false;
		}

		if (strike == 0) {
			System.out.println(ball + config.getBALL());
			return false;
		}

		return false;
	}

	private boolean checkRestart() {
		System.out.println(config.getAskRestart());
		String userRestartInput = Console.readLine();

		if (userRestartInput.equals("1")) {
			return true;
		}

		if (userRestartInput.equals("2")) {
			return false;
		}

		throw new IllegalArgumentException();
	}
}
