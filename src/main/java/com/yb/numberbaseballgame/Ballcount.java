/*
 * @(#)Ballcount.java	1.8.0_191 2019/03/27
 * 
 * Copyright (c) 2019 Youngbae Son
 * ComputerScience, ProgrammingLanguage, Java, Busan, KOREA
 * All rights reserved.
 * */

package com.yb.numberbaseballgame;

/*
 * 컴퓨터 숫자와 사용자 숫자를 비교해서
 * strike, ball 곗수를 저장하는 데이터 클래스
 * 
 * @author 손영배
 * */

public class Ballcount {
	/*strike, ball 멤버변수*/
	
	/*컴퓨터자와 사용자 숫자가 자리가 일치한다면 strike 증가*/
	private int strike;
	/*컴퓨터자와 사용자 숫자가 자리가 일치하지는 않지만 다른 자리에 있다면 ball 증가*/
	private int ball;
	
	/*get을 통해 클래스 변수 접근*/
	public int getStrike() {
		return strike;
	}

	/*set을 통해 클래스 변수 값 변경*/
	public void setStrike(int strike) {
		this.strike = strike;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}
	
	
}
