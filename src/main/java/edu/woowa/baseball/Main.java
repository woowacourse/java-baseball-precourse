/*
 * @Main.java		1.00 2019/03/26
 * 
 * Copyright(c)2019 	HwiJin Hong.
 * All right reserved.
 * 
 * 숫자 야구 게임 프로그램
 * 1~9까지 서로 다른 수로 이루어진 3자리 수를 맞추는 게임입니다.
 * 같은 수가 같은 자리에 있다면 스트라이크, 다른 자리에 있으면 볼, 해당하는 숫자가 전혀 없으면 "포볼"을 출력합니다.
 */

package edu.woowa.baseball;

/**
 * 숫자 야구 게임을 수행하기 위한 Main 클래스
 * @version 1.00 2019년 03월 26일
 * @author 홍휘진
 */
public class Main {
	
	public static void main(String[] args) {
		User user = new User();
		user.gameBegin();
	}
}
