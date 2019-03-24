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
	
	/**
	 * strike와 ball의 개수를 통해
	 * 정답인지 판별
	 * @param ball_cnt	[0] : strike, [1] : ball
	 * @return	오답일 경우 다시하기 위해
	 */
	public boolean checkAnswer(int[] ball_cnt) {
		
		//정답
		if(ball_cnt[0] == 3){
			System.out.println("3 스트라이크");
			return true;
		} else if((ball_cnt[0] == 0) && (ball_cnt[1] == 0)) {	// 낫싱
			System.out.println("낫싱");
		} else if(ball_cnt[1] == 0) {							// strike만 있을 경우
			System.out.println(ball_cnt[0] + " 스트라이크");
		} else if(ball_cnt[0] == 0) {							// ball만 있을 경우
			System.out.println(ball_cnt[1] + " 볼");
		} else {
			System.out.println(ball_cnt[0] + " 스트라이크 " + ball_cnt[1] + " 볼 ");
		}
		return false;
	}
	
	//strike 여부
	public boolean isStrike(int a, int b) {
		return a == b;
	}

	//ball 여부
	public boolean isBall(int[] answer, int[] input, int digit) {
		
		for(int i = 0; i < 3; i++) {
			
			//strike에서 이미 판별
			if(i == digit) continue;
			
			if(input[digit] == answer[i]) return true;
		}
		
		return false;
	}
	
	/**
	 * strike, ball 개수 확인
	 * @param answer	정답
	 * @param input 	사용자 입력
	 * @param ball_cnt	[0] : strike, [1] : ball 
	 */
	public void compareNum(int[] answer, int[] input, int[] ball_cnt) {
		
		for(int i = 0; i < 3; i++) {
			if(isStrike(answer[i], input[i])) ball_cnt[0]++;
			else if(isBall(answer, input, i)) ball_cnt[1]++;
		}
		
	}
	
	/**
	 * 3자리 수를 각각의 자리수에 따라 분리한다
	 * ex) 123 -> 1, 2, 3
	 * @param num 	3자리 수
	 * @return res 	자리 수에 따른 분리된 수
	 */
	public int[] splitNum(int num) {
		
		int[] res = new int[3];
		
		res[0] = num / 100;
		num = num % 100;
		
		res[1] = num / 10;
		num = num % 10;
		
		res[2] = num;
		
		return res;
	}
	
	/**
	 * 게임 플레이어는 3개의 숫자를 입력한다
	 * @return
	 */
	public int[] input() {
		
		String str;
		int input_num;
		int[] split_num = new int[3];
		
		System.out.print("숫자를 입력해주세요 : ");
		
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		input_num = Integer.parseInt(str);
		
		//입력한 숫자를 분리
		split_num = splitNum(input_num);
		
		return split_num;
	}
	
	/**
	 * 1부터 9까지 랜덤한 숫자 3개 생성
	 * 생성된 숫자는 서로 다른 수 (중복 x)
	 * @param randNum
	 */
	public void createNum(int[] randNum) {
		
		int cnt, temp;
		ArrayList num_list = new ArrayList();
		
		cnt = 0;
		while(cnt <= 2) {
			// 1~9 숫자 생성
			temp = (int) (Math.random() * 9) + 1;
			
			// 중복 판별
			if(num_list.contains(temp)) continue;
			
			randNum[cnt] = temp;
			num_list.add(temp);
			cnt++;
		}
	}
	
	/**
	 * 게임 종료 시, 재시작 or 완전 종료
	 * @return
	 */
	public static boolean replay() {
		int input;
		
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		
		Scanner sc = new Scanner(System.in);
		input = sc.nextInt();
		
		return input == 2;
	}
	
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
		
		createNum(answer);
		
		do {
			
			input_num = input();
			
			//strike, ball 개수 세기
			ball_cnt[0] = 0;
			ball_cnt[1] = 0;
			compareNum(answer, input_num, ball_cnt);
			
			isAnswer = checkAnswer(ball_cnt);
		
		} while(!isAnswer);
		
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
	
	public static void main(String[] args) {
		
		while(true) {
			Baseball bb_obj = new Baseball();
			bb_obj.game();
			
			if(replay()) break;
		}
		
		System.out.println("게임을 종료합니다.");
	}
}
