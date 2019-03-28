package edu.woowa.course.yagu;

import java.util.Random;

/**
*@version 1.00 2019/03/28
*@author 조재훈
*/
public class Catcher {

	private static final String BALL = "볼";
	private static final String STRIKE = " 스트라이크 ";
	private static final String NOTHING = "낫싱";
	private static final int COUNT = 3;
	private static final int RANDOM_SCOPE = 9;

	/** NumberMap is used to check if the number is generated first or not */
	private NumberMap catcherMap;
	private Random random;
	private	int ball;
	private	int strike;

	public void init() {
		catcherMap = new NumberMap();
		random = new Random();
		int value = 0;
		int i = 0;

		while (i < COUNT) {
			value = 1 + random.nextInt(RANDOM_SCOPE);
			if(catcherMap.getIndex(value) >= 0) {
				continue;
			}
			catcherMap.setIndex(value, i);
			i++;
		}
	}

	public boolean catching(int[] pitchingBallArr) {
		this.strike = 0;
		this.ball = 0;
		int index = 0;

		for (int i = 0; i < COUNT; i++) {
			index = catcherMap.getIndex(pitchingBallArr[i]);
			if ( index >= 0 ) {
				countingScore(index, i);
			}
		}

		printResult();

		return ((this.strike == COUNT) ? false : true);
	}

	private void countingScore(int key, int index) {
		if (key == index) {
			this.strike++;
		} else {
			this.ball++;
		}
	}

	private void printResult() {
	}
}
