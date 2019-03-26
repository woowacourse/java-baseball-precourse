/*
 * @Computer.java		1.00 2019/03/26
 * 
 * Copyright(c)2019 	HwiJin Hong.
 * All right reserved.
 * 
 * 숫자 야구 게임 프로그램
 * 1~9까지 서로 다른 수로 이루어진 3자리 수를 맞추는 게임입니다.
 * 같은 수가 같은 자리에 있다면 스트라이크, 다른 자리에 있으면 볼, 해당하는 숫자가 전혀 없으면 "포볼"을 출력합니다.
 * 컴퓨터는 기본적으로 3자리의 숫자 정보를 배열로 가지고 있습니다.
 * 사용자로부터 숫자를 생성해 달라는 요청(게임이 진행)을 받았을 때 서로 다른 숫자를 랜덤 메서드를 통해 생성합니다.
 * 게임진행 도중 사용자로부터 비교 요청을 받으면 비교 요청에 대한 결과를 배열로 리턴합니다.
 * 비교 요청에 대한 결과는 배열 인덱스 순서대로 스트라이크, 볼, 아웃 의 개수입니다.
 * 
 */

package edu.woowa.baseball;

/**
 * 숫자 야구 게임의 상대방 역할을 하는 컴퓨터 클래스
 * @version 1.00 2019년 03월 26일
 * @author 홍휘진
 */
public class Computer {
	
	/**
	 * 컴퓨터는 항상 3가지의 숫자 배열을 지니고 있어야 한다.
	 * 배열의 size는 항상 3으로 유지
	 */
	private static final int SIZE = 3;
	
	/**
	 * 컴퓨터가 저장할 서로 다른 3자리 숫자의 정보를 나타내는 객체
	 */
	private int[] arr;
	
	/**
	 * Computer 객체 생성시 메모리 할당을 위한 생성자
	 */
	public Computer() {
		this.arr = new int[SIZE];
	}
	
	/**
	 * 이미 썼던 데이터는 지우고 다시 배열을 초기화하는 메서드
	 */
	public void initNumber() {
		for (int i = 0; i < SIZE; i++) {
			arr[i] = 0;
		}
	}
	/**
	 * 이전에 사용했던 데이터는 지우고,
	 * 서로 다른 3가지 숫자를 생성하기 위한 메서드
	 */
	public void createNumber() {
		initNumber();
		arr[0] = (int) (Math.random()*9) + 1;
		do {
			arr[1] = (int) (Math.random()*9) + 1;
		} while(arr[0] == arr[1]);
		do {
			arr[2] = (int) (Math.random()*9) + 1;
		} while ( (arr[0] == arr[2]) || (arr[1] == arr[2]) );
	}
	
}
