package baseball;

public class Computer {
	final int START_INCLUSIVE = 1;
	final int END_INCLUSIVE = 9;
	boolean[] checkOverlapArray = new boolean[10];
	char[] randomNumbersArray = new char[Hint.BASE_BALL_GAME_RANGE];

	public boolean[] overLapNUmbersArray() {
		for (int i = 0; i < checkOverlapArray.length; i++) {
			checkOverlapArray[i] = false;
		}
		return checkOverlapArray;
	}

	public char[] inputRandomNumbersArray() {
		int count = 0;
		boolean[] already = overLapNUmbersArray();
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

}
