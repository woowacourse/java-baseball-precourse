/*
 * @(#)Computer.java		2019/3/27
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * Computer 클래스는 숫자 야구 게임을 진행하면서 사용자의 입력이 필요하지 않은 메소드들을 모아 놓은 클래스입니다. 
 * 
 * @version			1.00 2019년 3월 27일
 * @author 			한준모
 */

public class Computer {

	/** 컴퓨터가 만든 세 자리 숫자를 저장하는 배열 */
	public int[] comNum = new int[3];
	
	/** 
	 * 게임이 시작할 때 메세지를 출력하는 메소드입니다.
	 */
	public void printMessage() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	/**
	 * 게임의 정답이 되는 컴퓨터의 세 자리 숫자를 만드는 메소드입니다. 1부터 9까지 랜덤한 수를 comNum 배열에
	 * 저장한 후, 숫자들이 중복되지 않는지 확인합니다. 중복된다면 조건을 만족할 때까지 while문을 실행합니다.
	 */
	public void makeComputerNumber() {
		while (true) {
			for (int i=0; i<comNum.length; i++) {
				comNum[i] = (int)(Math.random() * 9) + 1;
			}
			if (comNum[0] != comNum[1] && comNum[1] != comNum[2] 
					&& comNum[2] != comNum[0]) {
				break;
			}
		}
	}
}
