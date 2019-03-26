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

	/**
	 * 정답자로부터 입력받은 숫자 문자열을 숫자인 배열로 담는다.
	 * @param strNumber 문자열 형태의 3자리 수
	 * @return 정답(3자리 숫자 배열)
	 * */
	public int[] setNumber(String strNumber) {

		/* 새로운 숫자를 입력 받으므로, 점수를 null 로 초기화 한다. */
		score = null;

		for(int i = 0; i < this.number.length; i++) {
			char c = strNumber.charAt(i);
			this.number[i] = c - '0'; /* 문자를 숫자로 변환 */
		}
		return this.number;
	}

	/**
	 * 정답(3자리 숫자 배열)을 반환한다.
	 * @return 정답(3자리 숫자 배열)
	 * */
	public int[] getNumber() {
		return this.number;
	}

	/**
	 * 새로운 점수를 받아 저장한다.
	 * @param score 받은 점수객체
	 * */
	public void setScore(Score score) {
		this.score = score;
	}
}