/*
 *NumberBaseball.class
 *
 *2019.03.28
 *
 * @author 최여진
 *
 */
import java.util.Scanner;


public class NumberBaseball {
	public static Scanner scan = new Scanner(System.in);
	public static void main (String[] args) {
		int userNum[] = new int[3];
		int comNum[] = new int[3];
		boolean result = false;
		boolean continued = true;
		
		
		while (continued) {
			comNum = getComNum();
		
			while (!result) {
				System.out.print ("숫자를 입력해주세요 : ");
				
				userNum = getUserNum();
				
				int strike = getStrike(comNum, userNum);
				int ball = getBall(comNum, userNum);
				
				result  =printResult(strike, ball);
			}
			
			System.out.println ("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println ("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			
			if (scan.nextInt() == 2) {
				continued = false;
			}
			else {
				result = false;
			}
		}
	}

	
	/*컴퓨터의 랜덤 함수를 불러오는 메소드*/
	public static int[] getComNum() {
		int comNum[] = new int[3];
		
		/*1에서 9까지의 랜덤 정수*/
		comNum[0] = ( int )(Math.random() * 9 + 1);
		
		while(true) {
			comNum[1]=( int )(Math.random() * 9 + 1);
			
			/*각 자리의 숫자들이 겹치지 않도록*/
			if(comNum[1] != comNum[0]) {
				break;
			}
		}
		
		while (true) {
			comNum[2]=( int )(Math.random() * 9 + 1);
			
			if ((comNum[2] != comNum[1]) && (comNum[2] != comNum[0]))
				break;
		}
		
		return comNum;
	}
	
	
	/*사용자의 세자리 수 입력 메소드*/
	public static int[] getUserNum() {
		int userNum[] = new int[3];
		
		int input = scan.nextInt();
		
		
		/*숫자 중복 되지 않도록 확인*/
		userNum[0] = input/100; //100의 자리
		input -= input/100*100; //100의 자리 날리기
		userNum[1] = input/10; //10의 자리
		userNum[2] = input%10; //1의 자리
		
		return userNum;
	}
	
	
	/*comNum과 userNum에 따른 스트라이크의 카운팅*/
	public static int getStrike (int[] comNum, int[] userNum) {
		int strike=0;
		
		for (int i  =0; i < 3; ++i) {
			if (comNum[i] == userNum[i]) {
				strike++;
			}
		}
		
		return strike;
	}
	
	
	/*comNum과 userNum에 따른 볼의 카운팅*/
	public static int getBall (int[] comNum, int[] userNum) {
		int ball=0;
		
		for (int i = 0; i < 3; ++i) {
			if (comNum[i] == userNum[(i + 1) % 3]) {
				ball++;
			}
			else if (comNum[i] == userNum[(i + 2) % 3]) {
				ball++;
			}
		}
		return ball;
	}
	
	
	/*결과 값 출력에 관한 메소드*/
	public static boolean printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + " 스트라이크  ");
		}
		if(ball != 0) {
			System.out.print(ball + "볼");
		}
		if(strike+ball == 0) {
			System.out.print("낫싱");
		}
		
		System.out.println();
		
		return (strike == 3);
		
	}
}

