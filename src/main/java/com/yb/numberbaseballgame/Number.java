/*
 * @(#)Number.java        1.8.0_191 2019/03/27
 * 
 * Copyright (c) 2019 Youngbae Son
 * ComputerScience, ProgrammingLanguage, Java, Busan, KOREA
 * All rights reserved.
 * */

package com.yb.numberbaseballgame;

/* 컴퓨터 숫자와 사용자 숫자를 담는 배열*/
public class Number {

	/*숫자를 담을 배열*/
	private int []number;

	public Number() {
		this.number = new int[3];
	}

	/*get을 통해 number의 index의 값 접근*/
	public int getNumber(int index) {
		return number[index];
	}

	/*set을 통해 number의 index에 value를 저장*/
	public void setNumber(int index, int value) {
		this.number[index] = value;
	}
	
	
	
}
