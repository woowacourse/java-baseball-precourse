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
	
	/** 스트라이크의 횟수를 저장하는 인스턴스 변수 */
	public int strikeCnt = 0;
	
	/** 볼의 횟수를 저장하는 인스턴스 변수 */
	public int ballCnt = 0;

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
	
	/**
	 * 컴퓨터 숫자와 사용자의 숫자들을 비교해서 스트라이크의 개수를 의미하는 변수 strikeCnt를 계산합니다. 
	 * @param userNum - 컴퓨터 숫자와 사용자 숫자들을 비교하기 위해서 파라미터로 참조
	 */
	public void countStrike(int[] userNum) {
		
		for(int i=0; i<comNum.length; i++) {
			if (comNum[i] == userNum[i]) {
				strikeCnt++;
			}
		}
	}
	
	/**
	 * 컴퓨터 숫자와 사용자의 숫자들을 비교해서 볼의 개수를 의미하는 변수 ballCnt 계산합니다.
	 * 개수를 계산하는 조건에서 스트라이크의 값도 중복해서 계산되므로 최종 값에서 strikeCnt의 값을 뺍니다.
	 * @param userNum - 컴퓨터 숫자와 사용자 숫자들을 비교하기 위해서 파라미터로 참조
	 */
	public void countBall(int[] userNum) {
		
		for(int i=0; i<comNum.length; i++) {
			if (comNum[i] == userNum[0] || comNum[i] == userNum[1] 
					|| comNum[i] == userNum[2]) {
				ballCnt++;
			}	
		}
		ballCnt -= strikeCnt;
	}
}
