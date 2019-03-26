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
	 * @param questioner 질문자
	 * @param answerer   답변자
	 */
	public Game(Questioner questioner, Answerer answerer) {

		this.questioner = questioner;
		this.answerer = answerer;
	}

	/**
	 * 질문자의 문제와 답변자의 정답을 비교하고, 답변자의 점수를 매긴다.
	 * */
	public void play() {

		int[] problem = questioner.getNumber(); /* 문제자의 3자리수 */
		int[] answer = answerer.getNumber(); /* 답변자의 3자리수 */
		Score score = new Score(); /* 점수를 매기기 위한 객체 */

		for(int i = 0; i < answer.length; i++) {

			/* 답변자의 정답을 기준으로 스트라이크, 볼의 개수를 검사한다. */
			if( checkStrike(problem, answer, i) ) {
				score.setStrike( score.getStrike()+1 );
			} else if( checkBall(problem, answer, i) ) {
				score.setBall( score.getBall()+1 );
			}
		}

		/* 답변자에게 점수를 준다. */
		answerer.setScore(score);
	}
}