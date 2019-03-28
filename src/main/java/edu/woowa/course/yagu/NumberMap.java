package edu.woowa.course.yagu;

/**
*@version 1.00 2019/03/28
*@author 조재훈
*/
public class NumberMap {

	private static int MAP_SCOPE = 10;
	private int[] ballIndex;

	public NumberMap() {
		ballIndex = new int[MAP_SCOPE];
		for(int i = 0 ; i < MAP_SCOPE; i++) {
			ballIndex[i] = -1;
		}
	}

	public int getIndex(int ball) {
		return ballIndex[ball];
	}

	public void setIndex(int ball, int index) {
		ballIndex[ball] = index;
	}
}