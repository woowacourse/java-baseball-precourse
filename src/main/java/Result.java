package main.java;

import java.util.Scanner;

public class Result {
	public int[] release(int strike, int ball) {
		
		int[] check_and_decision = new int[2];			// [성공여부, 재시작여부]
		int check = 0;			// 성공여부 기본값 0 (실패)
		int decision = 0;			// 재시작여부 기본값 0 (불가능)
		if (strike != 3) {			// 답을 맞추지 못했을 때
			
			if (strike != 0) {			// 스트라이크 갯수 출력
				System.out.print(strike + "스트라이크 ");
			}
			
			if (ball != 0) {			// 볼 갯수 출력
				System.out.print(ball + "볼 ");
			}
			
			if (strike == 0 && ball == 0) {			// 낫싱일 때 출력
				System.out.print("낫싱");
			}
			System.out.println();
		}else {			// 답을 맞췄을 때
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			
			while (decision != 1 && decision != 2) {			// 재시작여부 올바른 값 받기
				decision = restart();
			}
			
			check = 1;			// 성공여부 1으로 변경 (성공)
		}
		check_and_decision[0] = check;			// 성공여부 반영
		check_and_decision[1] = decision;			// 재시작여부 반영
		
		return check_and_decision;			// [성공여부, 재시작여부] 리턴
		
	}
	
	
	public int restart() {			// 재시작여부 값 받기
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		int start_or_not = scanner.nextInt();
		
		return start_or_not;
	}
}
