package baseball;

public class Hint {
	final static int BASE_BALL_GAME_RANGE = 3;

	Computer computer = new Computer();
	Player player = new Player();

	String inputNumbers;
	char[] userInputNumbersArray;
	char[] RandomNumbersArray = new char[BASE_BALL_GAME_RANGE];

	public void hintUserNumbersAndRandomNumbers() {
		boolean finish = false;
		RandomNumbersArray = computer.inputRandomNumbersArray();
		while (!finish) {
			inputNumbers = player.inputNumbers();
			userInputNumbersArray = player.userNumbersArray(inputNumbers);
			int strike = countStrike(RandomNumbersArray, userInputNumbersArray);
			int ball = countBall(RandomNumbersArray, userInputNumbersArray);
			if (strike == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				finish = true;
			}
			if (strike == 0 && ball == 0) {
				System.out.println("낫싱");
			}
			System.out.println(strike + " 스트라이크" + ball + "볼");
		}
	}

	public int countStrike(char[] computer, char[] user) {
		int strike = 0;

		for (int i = 0; i < BASE_BALL_GAME_RANGE; ++i) {
			if (computer[i] == user[i]) {
				strike++;
				continue;
			}
		}
		return strike;
	}

	public int countBall(char[] computer, char[] user) {
		int ball = 0;

		for (int i = 0; i < BASE_BALL_GAME_RANGE; ++i) {
			for (int j = 0; j < BASE_BALL_GAME_RANGE; ++j) {
				if (i == j) {
					continue;
				}
				if (computer[i] == user[j]) {
					ball++;
				}
			}
		}
		return ball;
	}
}
