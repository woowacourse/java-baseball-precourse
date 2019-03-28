import java.util.Scanner;
import java.util.InputMismatchException;

/* 
 * 클래스 이름 : Baseball
 * 기능 : 전반적인 게임메뉴를 설명하고 게임의 큰 절차를 진행한다.
 * 작성자 : HyukJin Kwon
 * 날짜 : 2019/03/28
 * 버전 : 1.1
 * Copyright (c) 2019 HyukJin Kwon
 */
public class Baseball {
	public void start_game() {
		Computer com = new Computer();
		Player user = new Player();
		
		com.create_num();
		while(true) {
			System.out.println("중복되지 않는 1 ~ 9 세자리 수를 입력해주세요");
			int input[] = user.user_num();
			com.count_s(input);
			com.count_b(input);
			com.result();
		}
	}
	// 게임을 시작하기 위한 메뉴를 case에 따라 나눕니다.
	public void gameMenu() {
		System.out.println("Play!! Baseball");
		System.out.println("게임을 하려면 1, 그만하려면 2를 입력하세요!");
		Scanner sc = new Scanner(System.in);
		int gameinput = 0;
			
		try {
		   gameinput = sc.nextInt();
		   switch(gameinput) {
			  case 1:
				System.out.println("게임시작");
				start_game();
				break;
			  case 2: 
				System.out.println("게임종료");
				break;	
			  default: // 1, 2 외의 숫자가 들어올 경우 재시작
				System.out.println("입력된 값이 잘못되었습니다. 재입력해주세요");
				gameMenu();
				break;
			    }
			}
			// 숫자가 아닌값 들어오면 재시작
			catch (InputMismatchException e) {
	            System.out.println("입력된 값이 잘못되었습니다. 재입력해주세요");
	            gameMenu();
	        }
	}
	public static void main(String[] args) {
		
		Baseball bs = new Baseball();
		bs.gameMenu();
	}
}
