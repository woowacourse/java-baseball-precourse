/*
 * @(#) Answerer.java     1.0   20191/03/26
 *
 * Released under the MIT license
 */

/**
 * Answerer 클래스는 숫자야구게임의 문제를 맞추기 위한 3자리수를 갖고 점수를 받는다.
 *
 * @version  1.00  2019년 03월 26일
 * @author   조남균
 */
public class Answerer {

	/** 답변자의 정답(서로 다른 3자리수) 배열 */
	private int[] number;

	/** 게임의 결과 점수를 객체 */
	private Score score;

	/**
	 * 답변자의 정답을 3자리 수로 초기화고 점수객체를 null 로 초기화한다.
	 */
	public Answerer() {
		this.number = new int[3]; // 3자리 수
		score = null;
	}
}