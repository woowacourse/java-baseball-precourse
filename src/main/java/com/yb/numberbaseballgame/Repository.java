/*
 * @(#)Repository.java        1.8.0_191 2019/03/27
 * 
 * Copyright (c) 2019 Youngbae Son
 * ComputerScience, ProgrammingLanguage, Java, Busan, KOREA
 * All rights reserved.
 * */

package com.yb.numberbaseballgame;

import java.util.Scanner;

/*
 * 3. 컴퓨터 난수 생성 : createNumber()
 * 4. 게임 가이드 메세지 출력 : guideMessage()
 * 5. 사용자의 값 입력 : input()
 * 6. 1~9이외 값, 중복 검사확인 : userNumCheck()
 * 7. 스트라이크, 볼인지 검사 : playGame()
 * 8. X 스트라이크 X 볼 : printBallCount()
 * 9. run() : 3 -> 4 -> 5 -> 6-> 7-> 8->  9.계속  or 종료
 * 
 * @author 손영배
 * */

public class Repository implements Service {

	/*
	 * 컴퓨터,사용자, 볼 카운트를 담는 객성을 생성
	 * 
	 * 라이프사이클 3 -> 4 -> 5 -> 6-> 7-> 8-> 9.계속 or 종료
	 *
	 * 게임을 계속 하게 된다면 while 실행 게임을 종료 하게된다면 while 탈출
	 *
	 */

	public void run() {

		/* 컴퓨터 숫자를 담을 객체 생성 */
		Number comNumber = new Number();

		/* 사용자 숫자를 담을 객체 생성 */
		Number userNumber = new Number();

		/* 볼 카운트를 담을 객체 생성 */
		Ballcount ballCnt = new Ballcount();

		/* 사용자 입력을 받는 String 타입 변수 */
		String inputNum;

		createNumber(comNumber);

		while (true) {

			guideMessage("ready");

			inputNum = input();

			if (!userNumCheck(userNumber, inputNum)) {
				continue;
			}

			ballCnt = playGame(comNumber, userNumber, ballCnt);

			printBallCount(ballCnt);

			if (ballCnt.getStrike() == 3) {
				guideMessage("correct");
				break;
			}
		}
	}

}
