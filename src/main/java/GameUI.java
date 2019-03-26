/*
 * @(#) GameUI.java     1.0   20191/03/26
 *
 * Released under the MIT license
 */

import java.util.Scanner;

/**
 * GameUI 클래스는 사용자와 게임을 진행을 위한 사용자인터페이스다.
 *
 * @version  1.00  2019년 03월 26일
 * @author   조남균
 */
public class GameUI {

	/**
	 * 질문자(컴퓨터)와 답변자(사용자)를 생성한 후 게임에 참여한다.
	 * */
	public static void main(String[] args) {
		Questioner questioner = new Questioner(); // 질문자(컴퓨터)
		Answerer answerer = new Answerer(); // 답변자(사용자)

		run(questioner, answerer);
	}

	/**
	 * 사용자에게 정답을 요구하고, 정답를 반환한다.
	 * @param sc 입력을 위한 Scanner 객체
	 * @return 사용자가 입력한 3자리수
	 * */
	private static String askNumber(Scanner sc) {

		System.out.print("숫자를 입력해주세요: ");
		String str_number = sc.nextLine();
		return str_number;
	}

	/**
	 * 게임 결과를 사용자에게 보여준다.
	 * @param score 사용자의 게임결과
	 * */
	private static void printScore(Score score) {
		if (score.isNothing()) {

			/* 사용자가 모두 틀렸을 경우 */
			System.out.println("낫씽");
		} else {

			/* 사용자가 모두 맞거나 일부 맞았을 경우 */
			if (score.getStrike() > 0) {
				System.out.printf("%d 스트라이크", score.getStrike());
			}
			if (score.getStrike() > 0 && score.getBall() > 0) {
				System.out.print(" ");
			}
			if (score.getBall() > 0) {
				System.out.printf("%d 볼", score.getBall());
			}
			System.out.println();
		}
	}

	/**
	 * 사용자에게 재시작 여부를 묻는다.
	 * @param sc 입력을 위한 Scanner 객체
	 * @return 사용자의 재시작 여부
	 * */
	private static boolean askRestart(Scanner sc) {

		boolean isRestart = false;
		String flagNum; // 사용자가 입력한 숫자

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		flagNum = sc.nextLine();

		if (flagNum.equals("1")) {
			isRestart = true;
		} else if (flagNum.equals("2")) {
			isRestart = false;
		}

		return isRestart;
	}
}