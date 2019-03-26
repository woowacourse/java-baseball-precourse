/*
 * @(#) Questioner.java     1.0   20191/03/26
 *
 * Released under the MIT license
 */

/**
 * Questioner 클래스는 숫자야구게임의 문제(서로 다른 3자리 수)를 만들고 소유한다.
 *
 * @version  1.00  2019년 03월 26일
 * @author   조남균
 */
public class Questioner {

	/** 문제(서로 다른 3자리수)의 배열 */
	private int[] number;

	/**
	 * 문제의 자리수를 3자리로 초기화한다.
	 */
	public Questioner() {
		this.number = new int[3]; // 3자리 수
	}
}