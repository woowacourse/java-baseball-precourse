/*
 * @(#)Main.java		2019/3/27
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * Main 클래스는 객체 Computer, User와 상호작용하며 전체적인 흐름을 보여줍니다. 
 * 
 * @version			1.00 2019년 3월 27일
 * @author 			한준모
 */

public class Main {
	/* 숫자 야구 게임의 전체적인 진행 과정을 볼 수 있는 클래스 입니다. */
	
	public static void main(String[] args) {
		Computer com = new Computer();
		User user = new User();
		
		boolean restart = true;     // 사용자로부터 숫자(1 혹은 2)를 받아 boolean 타입으로 저장
		boolean correct = false;	// 사용자가 입력한 숫자가 컴퓨터 숫자와 일치하면 true
		int userNum[];				// 사용자로부터 입력 받은 숫자를 저장하는 배열
		int hint;					// 메소드 giveHint()로부터 리턴 받은 스트라이크 횟수
		
		while (restart) {
				com.makeComputerNumber();
				correct = false;
			while (!correct) {
				com.printMessage();
				userNum = user.getNumber();
				com.countStrike(userNum);
				com.countBall(userNum);
				hint = com.giveHint();
				correct = com.isCorrectAnswer(hint, correct);
				com.reset(userNum);
			}
			restart = user.isRestart(restart);	
		}
		
	}

}
