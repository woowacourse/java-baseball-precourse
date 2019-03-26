package src.main.java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Baseball Game
 * 게임 규칙 : README.md 참조
 * @author 강연욱
 * @version 2019.03.24
 */

public class Baseball {
	/**
	 * 구현한 기능
	 * 1. 정답 숫자 생성
	 * 2. 정답 숫자 분리
	 * 3. 사용자 입력 받기
	 * 4. 정답 판별
	 * 5. 정답 출력
	 * 6. 재시작 or 종료
	 */
	
	public void intro() {
		System.out.println("게임을 시작합니다!");
		System.out.println("숫자 생성 중...");
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Baseball 게임 진행
	 */
	public void game() {
		
		boolean isAnswer;
		int[] answer = new int[3];
		int[] input_num = new int[3];
		int[] ball_cnt = new int[2];
		
		intro();
		
		Computer.createNum(answer);
		
		do {
			
			input_num = User.input();
			
			//strike, ball 개수 세기
			ball_cnt[0] = 0;
			ball_cnt[1] = 0;
			Computer.compareNum(answer, input_num, ball_cnt);
			
			isAnswer = Computer.checkAnswer(ball_cnt);
		
		} while(!isAnswer);
		
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
	
	
}
