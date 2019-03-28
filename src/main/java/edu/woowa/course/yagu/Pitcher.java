package edu.woowa.course.yagu;

/**
*@version 1.00 2019/03/28
*@author 조재훈
*/
public class Pitcher {

	private static final String PITCHER_MESSEAGE = "숫자를 입력해주세요:";
	private static final int COUNT = 3;
	private static final int DIGIT = 10;
	private int[] pitcherBallArr;
	private boolean[] isSaved;

	public Pitcher() {
		this.pitcherBallArr = new int[COUNT];
	}

	public int[] pitching() {
		do {
			System.out.print(PITCHER_MESSEAGE);
		} while (!isValid(Utils.getInput()));
		
		return pitcherBallArr;
	}

	/**
	 * @param pitcherBalls
	 * @return
	 * Returns false when
	 * 1) param is a negative integer
	 * 2) param has same number
	 * 3) the length of param is over 3
	 */
	private boolean isValid(int pitcherBalls) {
		return true;
	}
}
