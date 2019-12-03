/**
 * @(#)Cpu.java
 * 0.0.0
 * 2019/12/03
 * 저작권 및 라이센스
 */

package com.precourse.bassballapp;

/**
 * 숫자야구게임에서 문제출제 기능을 담당한다.
 * @version 0.0.0 2019년 12월 03일
 * @author tiroring
 */
public class Cpu {
	/* 랜덤숫자를 생성하고, 세자리수로 만들어 변수에 저장한다. */
	
	/** 컴퓨터의 답안을 저장하는 변수 */
	static int[] answerArr;
	
	/** 1~9 사이의 랜덤숫자를 생성하는 메서드 */
	static int getRandomNum() {
		return (int) (Math.random() * 9) + 1;
	}
	
	/** 답으로 쓰일 세자리 수를 만드는 메서드 */
	static int[] makeAnswer() {
		int[] result = new int[3];
		
		result[0] = getRandomNum();		//백의자리
		int tmpVal1 = getRandomNum();
		while(tmpVal1 == result[0]) {
			tmpVal1 = getRandomNum();
		}
		result[1] = tmpVal1;				//십의자리
		int tmpVal2 = getRandomNum();
		while(tmpVal2 == result[0] || tmpVal2 == result[1] ) {
			tmpVal2 = getRandomNum();
		}
		result[2] = tmpVal2;				//일의자리
		return result;
	}
}
