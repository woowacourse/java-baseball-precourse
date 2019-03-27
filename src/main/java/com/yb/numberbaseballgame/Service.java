/*
 * @(#)Service.java        1.8.0_191 2019/03/27				
 * 
 * Copyright (c) 2019 Youngbae Son
 * ComputerScience, ProgrammingLanguage, Java, Busan, KOREA
 * All rights reserved.
 * */

package com.yb.numberbaseballgame;

/*
 * 인터페이스 파일
 * 
 * 게임에 필요한 기능을 모두 담아둔 클래스
 * 
 * @author 손영배
 * */

public interface Service {

	void run();
	void createNumber(Number comNumber);
	void guideMessage(String message);
	String input();
	boolean userNumCheck(Number userNumber, String inputNum);
}
