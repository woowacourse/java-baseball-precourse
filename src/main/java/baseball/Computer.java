package baseball;

public class Computer {
	final boolean[] checkOverlapArray = new boolean[10];
	final char[] randomNumbersArray = new char[Constant.BASE_BALL_GAME_RANGE];

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
			int randomNumbers = utils.RandomUtils.nextInt(Constant.START_INCLUSIVE, Constant.END_INCLUSIVE);
			if (!alreadyInputNumber[randomNumbers]) {
				randomNumbersArray[count] = Integer.toString(randomNumbers).charAt(0);
				alreadyInputNumber[randomNumbers] = true;
				count++;
			}
		}
		return randomNumbersArray;
	}

}
