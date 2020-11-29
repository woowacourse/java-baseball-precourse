package baseball;

public class Computer {
	char[] randomNumbersArray = new char[3];
	boolean[] already = new boolean[10];
	final int START_INCLUSIVE = 1;
	final int END_INCLUSIVE = 9;
	int strike;
	int ball;
	
	
	public boolean[] overLapNUmbersArray() {
		for (int i = 0; i < already.length; i++) {
			already[i] = false;
		}
		return already;
	}
	
	public char[] inputRandomNumbersArray() {
		int count = 0;

		while (count < 3) {
			int randomNumbers = utils.RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
			if (!already[randomNumbers]) {
				randomNumbersArray[count] = Integer.toString(randomNumbers).charAt(0);
				already[randomNumbers] = true;
				count++;
			}
		}
		return randomNumbersArray;
	}
	
	public void checkUserNumbersAndRandomNumbers() {
		boolean finish = false;
		
		while (!finish) {
			strike = 0;
			ball = 0;
			for (int i = 0; i < 3; ++i) {
				for (int j = 0; j < 3; ++j) {
					if (0 == randomNumbersArray[j]) {
						if (i == j) {
							strike++;
						} else
							ball++;
					}
				}
			}

			System.out.println(strike + " 스트라이크" + ball + "볼");
			if (strike == 3) {
				System.out.println("축하합니다!");
				finish = true;
			}
		}

	}
	
}
