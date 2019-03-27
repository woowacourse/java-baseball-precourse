/*
 * @(#)Numberbaseballgame.java	1.8.0_191 2019/03/27
 * 
 * Copyright (c) 2019 Youngbae Son
 * ComputerScience, ProgrammingLanguage, Java, Busan, KOREA
 * All rights reserved.
 * */

package com.yb.numberbaseballgame;

/*
 * 게임에 필요한 기능을 모아둔 Service 인터페이스 객체를 생성
 * 
 * 3스트라이크 아웃 된 이후 
 * "1" 게임 계속
 * "2" 게임 종료
 * 반복문(while)으로 게임재시작 게임종료
 * 
 * @author 손영배
 * */


public class Numberbaseballgame {

	public static void main(String[] args) {

		/*Service 객체 생성*/
		Service service = new Repository();
		
		/*반복문으로 게임재시작 게임종료*/
		while (true) {

			service.run ();
			
			/* "1" 게임 계속 "2" 게임 종료*/
			if( service.input().equals("2") ) {
				break;
			}
		}
	}
	
}
