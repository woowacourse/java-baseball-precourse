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
		while (!finish) {
			inputNumbers = player.inputNumbers();
			userInputNumbersArray = player.userNumbersArray(inputNumbers);
			RandomNumbersArray = computer.inputRandomNumbersArray();
			int strike = countStrike(RandomNumbersArray,userInputNumbersArray);
			int ball = countBall(RandomNumbersArray,userInputNumbersArray);
			if (strike == 3) {
				System.out.println("축하합니다!");
				finish = true;
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
			for(int j = 0; j < BASE_BALL_GAME_RANGE; ++j) {
				if (computer[i] == user[i]) {
					continue;
				}
				ball++;
			}
			
		}
		return ball;
	}
}
