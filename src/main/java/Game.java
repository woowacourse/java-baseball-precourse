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

	/**
	 * 질문자의 문제와 답변자의 정답을 비교하고, 답변자의 점수를 매긴다.
	 */
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

	/**
	 * 답변자의 답을 기준으로 같은 숫자가 같은 자리에 있으면 스트라이크(Strike) 이다.
	 *
	 * @param problem 문제자의 정답 숫자 배열
	 * @param answer 답변자의 정답 숫자 배열
	 * @param index 답변자의 정답 숫자 배열의 위치
	 * @return 스트라이크 유무
	 */
	private boolean checkStrike(int[] problem, int[] answer, int index) {

		return ( ( problem[index] == answer[index] ) ? true : false );
	}

	/**
	 * 답변자의 답을 기준으로 같은 숫자가 다른 자리에 있으면 볼(Ball) 이다.
	 *
	 * @param problem 문제자의 정답 숫자 배열
	 * @param answer 답변자의 정답 숫자 배열
	 * @param index 답변자의 정답 숫자 배열의 위치
	 * @return 볼의 유무
	 */
	private boolean checkBall(int[] problem, int[] answer, int index) {

		boolean isBall = false;
		for(int i = 0; i < problem.length; i++) {
			if( (i != index) && (problem[i] == answer[index]) ) {
				isBall = true;
				break;
			}
		}
		return isBall;
	}

	/**
	 * 게임에 참여한 질문자를 반환한다.
	 *
	 * @return 질문자 객체
	 */
	public Questioner getQuestioner() {

		return this.questioner;
	}

	/**
	 * 게임에 참여한 답변자를 반환한다.
	 *
	 * @return 답변자 객체
	 */
	public Answerer getAnswerer() {

		return this.answerer;
	}
}