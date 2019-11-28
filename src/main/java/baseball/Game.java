package baseball;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String regExp = "^[1-9]*$";
		
		int flag = 0; // 게임을 다시 시작하거나 종료하기 위한 flag
		int[] answer;
		int[] userAns = new int[3];
		int strike, ball;
		
		Computer computer = new Computer();
		answer = computer.createAnswer(); //컴퓨터가 가지고 있는 정답 

		do {
			if(flag == 1) {
				answer = computer.createAnswer();
				flag = 0;
			}
			strike = ball = 0;
			
			Umpire umpire = new Umpire(answer);
			
			System.out.print("숫자를 입력해주세요: ");
			String input = sc.next();
			while(!input.matches(regExp) || input.length() != 3) {
				System.out.println("3자리 자연수만 입력 가능합니다. ");
				System.out.print("숫자를 입력해주세요: ");
				input = sc.next();
			}
			
			for(int i=0; i<3; i++) {
				userAns[i] = input.charAt(i) - '0';
			}
			boolean result = umpire.compare(answer, userAns);
			
			if(result) flag = sc.nextInt();
		} while(flag <= 1);
		
		System.exit(0);
	}
}
