/*
 * @(#) Game.java     1.0   20191/03/26
 *
 * Released under the MIT license
 */

/**
 * Game 클래스는 질문자와, 답변자의 게임을 진행하고 점수를 매긴다.
 *
 * @version  1.00  2019년 03월 26일
 * @author   조남균
 */
public class Game {

	/** 질문자 객체 */
	private Questioner questioner;

	/** 답변자 객체 */
	private Answerer answerer;

	/**
	 * questioner(질문자), answerer(답변자) 객체를 입력받아 초기화 한다.
	 *
	 * @param questioner 질문자
	 * @param answerer   답변자
	 */
	public Game(Questioner questioner, Answerer answerer) {

		this.questioner = questioner;
		this.answerer = answerer;
	}
}