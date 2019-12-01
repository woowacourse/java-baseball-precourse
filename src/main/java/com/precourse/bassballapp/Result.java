package com.precourse.bassballapp;

import java.util.InputMismatchException;
import java.util.Scanner; //newGameQuery에서 사용자 입력위해 필요.

import com.precourse.bassballapp.Cpu;

public class Result {
	static void print(int[] resultArr) {
		int strike = resultArr[0];
		int ball = resultArr[1];
		
		if (strike == 0 && ball == 0) {
			String tmp = "결과: 낫싱";
			System.out.println(tmp);
			
		} else if (strike == 3) {
			String tmp = "결과 :" + strike + " 스트라이크";
			System.out.println(tmp);
			String tmp2 = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
			System.out.println(tmp2);
			newGameQuery();
			
		} else if (strike == 0) {
			String tmp = "결과: " + ball + " 볼";
			System.out.println(tmp);
			
		} else if (ball == 0) {
			String tmp = "결과: " + strike + " 스트라이크";
			System.out.println(tmp);
			
		} else {
			String tmp = "결과: " +strike+ " 스트라이크 " +ball+ " 볼";
			System.out.println(tmp);
		}
	}
	
	static void newGameQuery() {
		int userInput = 0;
		
		while (true) {
			try {
				Scanner input = new Scanner(System.in);
				String tmp = "새 게임을 시작하려면 1, "
						+ "프로그램을 종료하려면 2를 입력하세요.";
				System.out.println(tmp);
				userInput = input.nextInt(); //사용자 입력
				break;
			} catch(InputMismatchException ime) {
				System.out.println("잘못된 입력: 정수를 입력하세요.");
			}
		}
		
		if (userInput != 1 && userInput != 2) {
			System.out.println("잘못된 입력: 1 혹은 2를 입력하세요.");
			newGameQuery();
		} else if (userInput == 1) {
			System.out.println("사용자 입력: " + userInput);
			System.out.println("새 게임을 시작합니다.");
			Cpu.answerArr = Cpu.makeAnswer();
		} else if (userInput == 2) {
			System.out.println("사용자 입력: " + userInput);
			System.out.println("게임을 종료합니다.");
			System.exit(0);
		}
	}
}
