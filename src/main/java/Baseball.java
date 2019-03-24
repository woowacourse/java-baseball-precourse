package src.main.java;

import java.util.ArrayList;
import java.util.Scanner;


public class Baseball {
	
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

	public void game() {
		
		int[] answer = new int[3];
		int[] input_num = new int[3];
		int[] ball_cnt = new int[2];
		
		createNum(answer);
		
		while(true) {
			
			input_num = input();
			
			//strike, ball 개수 세기
			ball_cnt[0] = 0;
			ball_cnt[1] = 0;
			compareNum(answer, input_num, ball_cnt);
			
			break;
		}
		
	}
	
	public static void main(String[] args) {
		
		Baseball bb_obj = new Baseball();
		bb_obj.game();
	}
}
