/**
 * @(#)BassballApp.java
 * 0.0.0
 * 2019/12/03
 * 저작권 및 라이센스
 */

package com.precourse.bassballapp;

import com.precourse.bassballapp.*;

/**
 * 실제 프로그램이 실행되는 클래스.
 * @version 0.0.0 2019년 12월 03일
 * @author tiroring
 */
public class BassballApp {
	/* 실제 프로그램이 실행되는 클래스 */
	
	/** 실제 프로그램이 실행되는 구역. 4개의 메서드가 실행된다. */
	public static void main(String[] args) {
		Cpu.answerArr = Cpu.makeAnswer();
		while (true) {
			/*
			//디버깅용 코드
			System.out.println("[[디버깅용 메세지]]-컴퓨터 세자리 수 : " 
					+ Cpu.answerArr[0] + ","
					+ Cpu.answerArr[1] + ","
					+ Cpu.answerArr[2]);
			*/
			
			User.answerArr = User.getValidAnswer2();
			int[] tmp1 = User.answerArr;
			int[] tmp2 = Cpu.answerArr;
			StrikeBall.resultArr = StrikeBall.count(tmp1, tmp2);
			Result.print(StrikeBall.resultArr);
		}
	}
}
