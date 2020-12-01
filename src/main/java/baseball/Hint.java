package baseball;

public class Hint {

	Computer computer = new Computer();
	Player player = new Player();

	public void hintUserNumbersAndRandomNumbers() {
		boolean finishGame = false;
		char[] RandomNumbersArray = computer.inputRandomNumbersArray();
		char[] userInputNumbersArray;

		while (!finishGame) {
			String inputNumbers = player.inputNumbers();
			userInputNumbersArray = player.userNumbersArray(inputNumbers);
			int strike = countStrike(RandomNumbersArray, userInputNumbersArray);
			int ball = countBall(RandomNumbersArray, userInputNumbersArray);

			if (strike == Constant.BASE_BALL_GAME_RANGE) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				finishGame = true;
				break;
			}

			printBallAndStrike(strike, ball);
			printNothing(strike, ball);
			printStrike(strike, ball);
			printBall(strike, ball);
		}
	}

	private int countStrike(char[] computer, char[] user) {
		int strike = Constant.MIN_LENGTH;

		for (int i = 0; i < Constant.BASE_BALL_GAME_RANGE; ++i) {
			if (computer[i] == user[i]) {
				strike++;
				continue;
			}
		}
		return strike++;
	}

	private int countBall(char[] computer, char[] user) {
		int ball = Constant.MIN_LENGTH;

		for (int i = 0; i < Constant.BASE_BALL_GAME_RANGE; ++i) {
			for (int j = 0; j < Constant.BASE_BALL_GAME_RANGE; ++j) {
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

	private void printNothing(int strike, int ball) {

		if (ball == Constant.MIN_LENGTH && strike == Constant.MIN_LENGTH) {
			System.out.println("낫싱");
		}

	}

	private void printStrike(int strike, int ball) {
		if (ball == Constant.MIN_LENGTH && strike > Constant.MIN_LENGTH) {
			System.out.println(strike + " 스트라이크");
		}
	}

	private void printBall(int strike, int ball) {
		if (strike == Constant.MIN_LENGTH && ball > Constant.MIN_LENGTH) {
			System.out.println(ball + " 볼");
		}
	}

	private void printBallAndStrike(int strike, int ball) {
		if (strike > Constant.MIN_LENGTH && ball > Constant.MIN_LENGTH) {
			System.out.println(strike + " 스트라이크" + ball + " 볼");
		}
	}

}
