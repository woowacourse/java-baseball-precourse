/* 
 * 	@(#)MainClass.java				03/25/2019
 */

package com.sunkwan1weekMission;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * MainClass: main메서드가 포함되어있는 class이며 숫자야구게임의 시작부터 종료까지를 담당한다.
 * 
 * @author			김선관
 * @version			우아한 테크코스 1주차 미션 - 숫자 야구 게임
 */
public class JavaBaseball {
	
	/**
	 * NUMBERS:			숫자의 개수를 의미하는 상수
	 * THREE_DIGITS:	숫자야구게임을 몇 자리수로 할 것인지를 의미하는 상수, 현재는 세 자리수를 이용
	 */
	static final int NUMBERS = 10;
	static final int THREE_DIGITS = 3;
	
	/** 
	 * ansArr:		컴퓨터가 무작위로 뽑은 숫자가 저장될 배열
	 * userInArr:	사용자가 선택한 숫자가 저장될 배열 
	 */
	public static int[] ansArr = new int[THREE_DIGITS];
	public static int[] userInArr = new int[THREE_DIGITS];
	
	/** 
	 * strike:	strike의 수를 세는 변수
	 * ball:	ball의 수를 세는 변수
	 */
	public static int strike;
	public static int ball;
	
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * main(args):		main메서드이며, parameter는 사용하지 않는다
	 * 					숫자야구게임의 시작부터 종료까지를 담당하는 메서드
	 * 					exitMode메서드의 리턴값으로부터 불린 변수 status에 게임을 계속 할지에 대한 정보를 저장한다.
	 * 					1. status = true:	다음 게임을 시작한다.
	 * 					2. status = false:  프로그램을 종료한다.	
	 * @param args:	미사용
	 */
	public static void main(String[] args) {
		boolean status = true;
		
		while (status) {
            setAnsArr();			/* 0 ~ 9의 수를 무작위로 뽑아 ansArr배열에 저장한다. */
//            startGame();			/* 현재 게임을 시작한다. 게임은 ansArr배열과 userInArr배열이 일치할 경우 종료된다. */
//			status = exitMode();	/* 사용자에게 다음 게임을 시작할지에 대해 입력받는다. */
		}
		scanner.close();
	}
	
	/** 
	 * setAnsArr(): 	무작위로 숫자를 뽑아 ansArr에 저장하는 메서드.
	 */
	/*-
	 * setAnsArr의 구현:	0 ~ 9의 수가 순차적으로 저장된 ArrayList에서 무작위 번째 방을 선택하여 pop한다.
	 * 					이를 THREE_DIGITS번 만큼 반복한다. 결과적으로 THREE_DIGITS개수만큼의 서로다른 무작위 수를 만들 수 있다.
	 */
	public static void setAnsArr() {
		ArrayList<Integer> numbSeqArr = new ArrayList<>();
		
		setArrayList(numbSeqArr);
		popArrayList(numbSeqArr);
	}
	
	/**
	 * setArrayList(numbSeqArr): 0 ~ 9 까지 순차적으로 저장된 ArrayList를 만든다.
	 * 
	 * @param numbSeqArr: 0 ~ 9 까지 순차적으로 저장되어 있는 ArrayList
	 */
	public static void setArrayList(ArrayList<Integer> numbSeqArr) {
		for (int i = 0; i < NUMBERS; ++i) {
			numbSeqArr.add(i);						// 0 ~ 9 까지 순차적으로 저장된 ArrayList를 만든다.
		}
	}
	
	/**
	 * popArrayList(numbSeqArr): numbSeqArr의 무작위 번째 방의 값을 ansArr[i = 0 ~ THREE_DIGITS]에 저장한다.  
	 * 
	 * @param numbSeqArr: 0 ~ 9 까지 순차적으로 저장되어 있는 ArrayList
	 */
	public static void popArrayList(ArrayList<Integer> numbSeqArr) {
		Random random = new Random();
		int popIdx;
		
		for (int i = 0; i < THREE_DIGITS; ++i) {
			popIdx = random.nextInt(NUMBERS - i);	// 무작위번째 ArrayList의 값을 ansArr[i]에 저장한다. 
			ansArr[i] = numbSeqArr.get(popIdx);
			numbSeqArr.remove(popIdx);				// 선택된 ArrayList의 값은 remove하여 값의 중복을 피한다.
		}
	}
	
	/** startGame():	게임 시작 메서드
	 *					ansArr배열과 userInArr배열이 일치할 경우 현재 게임을 종료한다. 
	 */
	public static void startGame () {
		boolean isEnd = false;
		int userInNum;
		while(!isEnd) {
            strike = 0;
            ball = 0;
            
            System.out.print("숫자를 입력해주세요: ");
			userInNum = scanner.nextInt();
			
			numDivider(userInNum);		
			idxCounter();				
			
			isEnd = is3Strike();		
		}
	}
	
	/**
	 * numDivider(userInNum):	userInNum의 각 자리수를 분리하여 userInArr에 순차적으로 저장시키는 메서드이다.
	 * 
	 * @param userInNum:	사용자가 입력한 수가 저장되어 있는 변수
	 */
	public static void numDivider(int userInNum) {
		int divider;
		for (int i = 0; i < THREE_DIGITS; ++i) {
			divider = 1;
			for (int j = i; j < THREE_DIGITS - 1; ++j) {
				divider *= NUMBERS;
			}
			userInArr[i] = userInNum / divider;
			userInNum = userInNum % divider;
		}
	}
	
	/**
	 * idxCounter():	ansArr과 userInArr을 비교하기 위해 index를 순차적으로 증가시키는 메서드.
	 */
	public static void idxCounter() {
		for (int ansIdx = 0; ansIdx < THREE_DIGITS; ++ansIdx) {
			for (int inIdx = 0; inIdx < THREE_DIGITS; ++inIdx) {
//				compareValue(ansIdx, inIdx);		// 2-2-1
			}
		}
	}
	
	/** 스트라이크가 THREE_DIGITS일 경우 게임을 종료한다. 그 외의 경우 strike와 ball의 개수에 관한 메세지만 출력.
	 * 
	 * @return	boolean변수를 반환한다.
	 * 			true: 게임을 종료, false: 게임을 계속함
	 */
	public static boolean is3Strike () {
		if (strike == THREE_DIGITS) {
			System.out.println(strike + "스트라이크");
			System.out.println(THREE_DIGITS + "개의 숫자를 모두 맞히셨습니다! 게임종료");
			return true;	/* 3 strike인 경우 게임 종료 */
		} else {
			if ((strike == 0) && (ball == 0)) {
				System.out.println("낫싱");
			} else if (strike == 0) {
				System.out.println(ball + " 볼");
			} else if(ball == 0) {
				System.out.println(strike + " 스트라이크");
			} else {
				System.out.println(strike + " 스트라이크 " + ball + " 볼");	
			}
			return false;	/* 3 strike가 아닌 경우 게임 계속 */
		}
	}
}










