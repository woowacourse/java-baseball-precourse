/*
 * @(#) Score.java     1.0   20191/03/26
 *
 * Released under the MIT license
 */

/**
 * Score 클래스는 게임결과 점수를 갖고 있다.
 *
 * @version  1.00  2019년 03월 26일
 * @author   조남균
 */
public class Score {

	/** 스트라이크의 개수 */
	private int strike;

	/** 볼의 개수 */
	private int ball;

	/**
	 * Score 를 생성시 스트라이크의 개수와 볼의 개수를 0으로 초기화 한다.
	 */
	public Score() {
		this.strike = 0;
		this.ball = 0;
	}

	/**
	 * 스트라이크의 개수를 반환한다.
	 * @return 스트라이크 개수
	 * */
	public int getStrike() {
		return this.strike;
	}

	/**
	 * 스트라이크의 개수를 변경한다.
	 * @param strike 스트라이크 개수
	 * */
	public void setStrike(int strike) {
		this.strike = strike;
	}
}