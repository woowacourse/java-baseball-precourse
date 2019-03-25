/*
 * baseball
 * 
 * 1.0
 * 
 * 2019.03.25
 * 
 * heebg2
 * 
 * */

import java.util.*;

public class baseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean answer = true;
		while(answer) {
			answer = playGame();
		}
		System.out.println("게임을 종료합니다.");
	}
	
	/*
	 * 게임 실행
	 * param : 
	 * return : res
	 * 게임을 계속할지, 그만 할지 결정.
	 * */
	public static boolean playGame() {
		int answer = makeAnswer();
		
		System.out.print("숫자를 입력해주세요 : ");
		Scanner num = new Scanner(System.in);
		int number = num.nextInt();
		
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		
		Scanner sc = new Scanner(System.in);
		int resInt = sc.nextInt();
		boolean res = resInt == 2 ? false : true;
		
		return res;
	}
	
	/*
	 * 컴퓨터 정답 생성
	 * param :
	 * return : number
	 * 3자리 난수 생성(1~9 / 중복 안됨)
	 * */
	public static int makeAnswer() {
		int num[] = new int[3];
		int number = 0;
		Random rand = new Random();
		for(int i = 0 ; i < num.length ; i++) {
			num[i] = rand.nextInt(9) + 1;
			i = deDupl(i,num);
		}
		
		for(int i = 0 ; i < num.length ; i++) {
			number += num[i]*Math.pow(10, i);
		}
//		System.out.println(number);
		
		return number;
	}
	
	/*
	 * 중복 값 제거
	 * param : i, num
	 * return : i
	 * 3자리 난수 생성 중 중복된 값이 있으면 i값을 감소.
	 * */
	public static int deDupl(int i, int[] num) {
		for(int j = 0 ; j < i ; j++) {
			if(num[j] == num[i]) {
				i--;
				break;
			}
		}
		
		return i;
	}

}
