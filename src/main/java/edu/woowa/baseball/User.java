/*
 * @User.java		1.00 2019/03/26
 * 
 * Copyright(c)2019 	HwiJin Hong.
 * All right reserved.
 * 
 * 숫자 야구 게임 프로그램
 * 1~9까지 서로 다른 수로 이루어진 3자리 수를 맞추는 게임입니다.
 * 같은 수가 같은 자리에 있다면 스트라이크, 다른 자리에 있으면 볼, 해당하는 숫자가 전혀 없으면 "포볼"을 출력합니다.
 * 사용자는 컴퓨터 클래스에 접근할 수 있는 객체와 Scanner객체를 내장하고 있ㅅ브니다.
 * Scanner 객체를 통해 입력값을 입력 받으면, 입력값에 따라 조건 분기가 나뉘어지게 됩니다.
 * 값이 정상적일 경우 원래 흐름대로 로직이 수행되며, 값이 비정상적일 경우 재입력받게 됩니다.
 * 서로 다른 3자리 숫자를 입력받으면 컴퓨터가 가지고 있는 숫자와 비교 연산한 결과를 토대로
 * 스트라이크 볼 의 개수를 출력하게 됩니다.
 * 만약, 3스트라이크 라면 숫자를 맞춘것이므로 다시 게임에 도전할 것인지 물어보게 됩니다.
 */

package edu.woowa.baseball;

import java.util.Scanner;

/**
 * 숫자 야구 게임의 사용자 역할을 하는 사용자 클래스
 * @version 1.00 2019년 03월 26일
 * @author 홍휘진
 */
public class User {
	
	/**
	 * 사용자로부터 입력값을 받고 저장하기 위한 객체
	 */
	private Scanner sc;
	
	/**
	 * 컴퓨터 클래스에 접근하기 위한 객체
	 */
	private Computer cp;
	
	/**
	 * 생성자를 따로 두지 않는 클래스이므로, 메인 로직 시작시 객체를 생성시키고 시작한다.
	 * process의 입력값에 따라서, 게임을 진행할 것인지 종료할 것인지 결정하게 된다.
	 * 주어진 입력 외의 다른값이 오게 된다면, 입력 오류 메세지를 띄우고 재입력 받게 된다.
	 * 게임이 종료될 때는 안내 메세지와 함께 사용했던 Scanner객체를 close()하여
	 * 정상적으로 입력스트림을 닫고 프로그램이 종료된다.
	 */
	public void gameBegin() {
		init();
		String process;
		boolean logic = true;
		
		while (logic) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			process = scanInput();
			switch (process) {
			case "1":
				matchNumber();
				break;
			case "2":
				System.out.println("게임이 정상적으로 종료되었습니다!");
				sc.close();
				logic = false;
				break;
			default:
				System.out.println("[입력오류] 잘못된 값을 입력하셨습니다.");
				break;
			}
		}
	}

	/**
	 * 클래스 변수 객체를 생성시켜주는 메서드
	 */
	private void init() {
		sc = new Scanner(System.in);
		cp = new Computer();
	}
	
	/**
	 * 입력값을 받아서 리턴하는 메서드
	 */
	private String scanInput() {
		return sc.nextLine();
	}
}
