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

	/*
	 * Computer 숫자를 생성하는 함수
	 * 
	 * @param comNumber[0],[1],[2] 자리에 1~9자리 숫자 생성
	 * 
	 * Math.random() 함수는 0.0 ~ 1.0 값을 생성하기 때문에 *10를 증가 후 범위를 0~10 만들어 0, 10만 제외한
	 * 1~9의 수 를 comNumber[0],[1],[2] 자리에 저장
	 * 
	 */
	public void createNumber(Number comNumber) {

		int index = 0;
		int value = 0;
		boolean[] visit = new boolean[10];

		while (index < 3) {

			value = (int) (Math.random() * 10);

			if (value == 0 || value == 10 || visit[value]) {
				continue;
			} else {
				comNumber.setNumber(index, value);
				visit[value] = true;
				index++;
			}
		}

	}
}
