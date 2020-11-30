package baseball;

public class Computer {
	final int START_INCLUSIVE = 1;
	final int END_INCLUSIVE = 9;
	final boolean[] checkOverlapArray = new boolean[10];
	final char[] randomNumbersArray = new char[Hint.BASE_BALL_GAME_RANGE];

	public boolean[] overLapNumbersCheckArray() {
		for (int i = 0; i < checkOverlapArray.length; i++) {
			checkOverlapArray[i] = false;
		}
		return checkOverlapArray;
	}

	public char[] inputRandomNumbersArray() {
		int count = 0;
		boolean[] alreadyInputNumber = overLapNumbersCheckArray();
		while (count < 3) {
			int randomNumbers = utils.RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
			if (!alreadyInputNumber[randomNumbers]) {
				randomNumbersArray[count] = Integer.toString(randomNumbers).charAt(0);
				alreadyInputNumber[randomNumbers] = true;
				count++;
			}
		}
		return randomNumbersArray;
	}

}
