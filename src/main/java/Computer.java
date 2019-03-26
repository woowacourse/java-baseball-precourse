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
	
	/**
	 * 변수 strikeCnt와 ballCnt를 바탕으로 개수를 콘솔창에 출력합니다.
	 * @return strikeCnt - 변수 strikeCnt를 리턴하여 이후에 실행되는 isCorrectAnswer() 메소드 논리의
	 * 					   근거를 마련
	 */
	public int giveHint() {
		if (strikeCnt == 0 && ballCnt == 0) {
			System.out.println("낫싱");
		} else if (ballCnt == 0) {
			System.out.println(strikeCnt + " 스트라이크");
			if (strikeCnt == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			}
		} else if (strikeCnt == 0) {
			System.out.println(ballCnt + "볼");
		} else {
			System.out.println(strikeCnt + " 스트라이크 " + ballCnt + "볼");
		}
		return strikeCnt;
	}
	
	/**
	 * 컴퓨터 숫자와 사용자 숫자 비교해 얻은 변수 hint(스트라이크 횟수)를 통해서 사용자로부터 숫자를
	 * 계속 받는지 다음 단계로 진행되는지를 판단하는 메소드입니다.
	 * @param hint - giveHint() 메소드에서 strikeCnt를 리턴 받아 판단의 근거인 hint 변수에
	 * 		         저장하여 isCorrectAnswer() 메소드에서 파라미터로 참조
	 * @param correct - 사용자로부터 숫자를 계속 입력 받을지를 결정하는 boolean 타입 파라미터
	 * @return correct - 사용자로부터 숫자를 계속 입력 받을지를 결정하는 boolean 타입 파라미터
	 */
	public boolean isCorrectAnswer(int hint, boolean correct) {
		if (hint == 3) {
			correct = true;
		} else {
			correct = false;
		}
		
		return correct;
	}
	
	/**
	 * 숫자 야구 게임을 다시 시작하기 위해서 사용자로부터 입력 받은 숫자를 저장한 배열과 스트라이크 횟수
	 * 볼 횟수를 초기화하는 메소드입니다.
	 * @param userNum - 사용자로부터 입력 받은 숫자를 저장하는 배열을 초기화하기 위해 파라미터로 참조
	 */
	public void reset(int[] userNum) {
		userNum = new int[3];
		strikeCnt = 0;
		ballCnt = 0;
	}
	
}
