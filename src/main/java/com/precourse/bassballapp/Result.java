/**
 * @(#)Result.java
 * 0.0.0
 * 2019/12/03
 * 저작권 및 라이센스
 */

package com.precourse.bassballapp;

import java.util.InputMismatchException;
import java.util.Scanner; //newGameQuery에서 사용자 입력위해 필요.
import com.precourse.bassballapp.Cpu;

/**
 * 연산결과를 출력하고, 새 게임을 세팅하는 역할을 담당한다.
 * @version 0.0.0 2019년 12월 03일
 * @author tiroring
 */
public class Result {
	
	/** 사용자가 답을 맞추기 위해 시도한 횟수를 기록하는 변수 */
	static int trialCount = 0;
	
	/** 연산결과배열을 입력받아 콘솔창에 적절한 결과메세지를 출력한다. */
	static void print(int[] resultArr) {
		int strike = resultArr[0];
		int ball = resultArr[1];
		trialCount += 1;
		System.out.println(trialCount + "번째 시도");
		
		if (strike == 0 && ball == 0) {
			String tmp = "결과: None";
			System.out.println(tmp);
			
		} else if (strike == 3) {
			String tmp = "결과 :" + strike + " 스트라이크";
			System.out.println(tmp);
			String tmp2 = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
			System.out.println(tmp2);
			newGameQuery();		//새 게임 세팅
			
		} else if (strike == 0) {
			String tmp = "결과: " + ball + " 볼";
			System.out.println(tmp);
			
		} else if (ball == 0) {
			String tmp = "결과: " + strike + " 스트라이크";
			System.out.println(tmp);
			
		} else {
			String tmp = "결과: " +strike+ " 스트라이크 " +ball+ " 볼";
			System.out.println(tmp);
		}
		String tmpLine = "==================================" + 
				"===============================";
		System.out.println(tmpLine);
	}
	
	/** 정답을 맞춘 이후 호출되어서 새 게임을 세팅하거나, 게임을 종료한다. */
	static void newGameQuery() {
		
		/** 사용자 입력을 저장할 변수 */
		int userInput = 0;
		
		while (true) {
			try {
				Scanner input = new Scanner(System.in);
				String tmp = "새 게임을 시작하려면 1, "
						+ "프로그램을 종료하려면 2를 입력하세요.";
				System.out.println(tmp);
				userInput = input.nextInt(); //사용자 입력
				break;
			} catch (InputMismatchException ime) {
				System.out.println("잘못된 입력: 정수를 입력하세요.");
			}
		}
		
		if (userInput != 1 && userInput != 2) {
			System.out.println("잘못된 입력: 1 혹은 2를 입력하세요.");
			newGameQuery();
		} else if (userInput == 1) {
			System.out.println("사용자 입력: " + userInput);
			System.out.println("<<<새 게임을 시작합니다.>>>");
			Cpu.answerArr = Cpu.makeAnswer();
			trialCount = 0;
		} else if (userInput == 2) {
			System.out.println("사용자 입력: " + userInput);
			System.out.println("<<<게임을 종료합니다.>>>");
			System.exit(0);
		}
	}
}
