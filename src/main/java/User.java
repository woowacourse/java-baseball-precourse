/*
 * @(#)User.java		2019/3/27
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * User 클래스는 숫자 야구 게임에서 사용자의 입력이 필요한 메소드를 모아 놓은 클래스입니다. 
 * 
 * @version			1.00 2019년 3월 27일
 * @author 			한준모
 */

import java.util.Scanner;

public class User {
	
	Scanner sc = new Scanner(System.in);
	
	/** 사용자로부터 입력 받은 숫자를 저장하는 인스턴스 변수 */
	public int userInput;
	
	/** 사용자로부터 입력 받은 세 자리 숫자를 저장하는 배열 */
	public int[] userNum = new int[3];
	
	/**
	 * 사용자로부터 숫자를 입력 받는 메소드입니다. 네 가지의 조건을 만족하는 숫자를 userNum에 저장해 리턴합니다.
	 * 먼저 while 문을 통해서 사용자로부터 숫자만을 입력 받습니다. 두 번째는 그 숫자가 세 자리로 이루어졌는지,
	 * 세 번째는 서로 다른 숫자인지, 마지막은 해당 숫자에 0이 없는지 확인합니다.
	 * 조건 1번을 통해 숫자를 입력받고 조건 2, 3, 4번을 && 연산자로 확인해서 조건을 만족하는 수가 나올 때까지
	 * while문을 반복합니다. 
	 * 
	 * @return userNum - 사용자로부터 숫자를 입력 받아 그것을 저장한 배열.
	 */
	public int[] getNumber() {
		
		while (true) {
			while (!sc.hasNextInt()) {
				sc.next();
				System.out.println("1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력해주세요 ");
			}
			
			userInput = sc.nextInt();
	
			boolean isThreeDigit = ( userInput > 99 ) && ( userInput < 1000 );
			boolean isDifferent = ( userInput / 100 != (userInput / 10) % 10 ) 
								 && (userInput/10)%10 != userInput%10 && userInput%10 != userInput/100; 
			boolean hasnZero = userInput/100 != 0 && (userInput/10)%10 != 0 
					          && userInput%10 != 0;
			
			if (isThreeDigit && isDifferent && hasnZero) {
				userNum[0] = userInput/100;
				userNum[1] = (userInput/10)%10;
				userNum[2] = userInput%10;
				return userNum;
			}
		}
	}
}
