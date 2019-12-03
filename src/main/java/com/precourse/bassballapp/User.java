/**
 * @(#)User.java
 * 0.0.0
 * 2019/12/03
 * 저작권 및 라이센스
 */

package com.precourse.bassballapp;

import java.util.InputMismatchException; //예외처리위해 필요.
import java.util.Scanner; //사용자 입력위해 필요.

/**
 * 사용자로부터 답을 입력받는 역할을 담당한다.
 * @version 0.0.0 2019년 12월 03일
 * @author tiroring
 */
public class User {
	/* 
	 * getAnswer - getValidAnswer - getValidAnswer2 순으로
	 * 유효성 검사가 적용되기 때문에, 제일 우측의 메서드를 사용해야 한다 
	 */
	
	/** 입력받은 답안을 담는 변수 */
	static int[] answerArr;
	
	/** 사용자로부터 답을 입력받는 메서드 */
	static int[] getAnswer(){
		int[] result = new int[4];
		Scanner input = new Scanner(System.in);
		
		String tmpTxt = "사용자 입력: 1 ~ 9 사이의 서로다른 정수로 이루어진"
				+ " 세자리 수를 입력하세요 :";
		System.out.println(tmpTxt);
		
		int initial = input.nextInt();		//사용자입력
		
		result[0] = initial;
		result[1] = initial / 100;
		result[2] = (initial % 100) / 10;
		result[3] = initial % 10;
		
		String tmpTxt2 = "사용자 입력: " +initial+ "을 입력하였습니다.";
		System.out.println(tmpTxt2);
		
		return result;
	}
	
	/** 사용자 입력이 정수가 아니면 오류메시지 출력 후 재호출 */
	static int[] getValidAnswer() {
		while (true) {
			try {
				return getAnswer();
			} catch(InputMismatchException ime) {
				System.out.println("잘못된 입력: 정수를 입력하세요.");
				continue;
			}
		}
	}
	
	/** 사용자 입력이 세자리의 서로다른 수가 아니면 오류메시지 출력 후 재호출 */
	static int[] getValidAnswer2() {
		int[] result;
		while (true) {
			result = getValidAnswer();
			
			if (result[0] >= 1000 || result[0] < 100) {
				String tmpTxt = "잘못된 입력: 세자리 수를 입력하세요.";
				System.out.println(tmpTxt);
				
			} else if (result[2] == 0 || result[3] == 0) {
				String tmpTxt = "잘못된 입력: 1~9 사이 수를 입력하세요.";
				System.out.println(tmpTxt);
				
			} else if (result[1] == result[2] 
					|| result[1] == result[3] 
					|| result[2] == result[3]) {
				String tmpTxt = "잘못된 입력: 서로 다른 세 수를 입력하세요.";
				System.out.println(tmpTxt);
				
			} else {
				return result;
			}
		}
	}
}

