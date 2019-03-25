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
//		System.out.println(answer);				/* 정답 확인시 주석 해제 */
		
		int[] hint = new int[2];
		while(true) {
			hint = rightAnswer(answer);
			printHint(hint);
			if(hint[0] == 3) {
				break;
			}
		}
		
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
		
		return number;
	}
	
	/*
	 * 중복 값 제거
	 * param : i, num
	 * return : i
	 * 컴퓨터 정답 생성 시 3자리 난수 생성 중 중복된 값이 있으면 i값을 감소.
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
	
	/*
	 * 숫자 입력받아 맞추기
	 * param : answer
	 * return : hint
	 * 값을 입력받아 정답(힌트들) 전달.
	 * */
	public static int[] rightAnswer(int answer) {
		System.out.print("숫자를 입력하세요 : ");
		Scanner num = new Scanner(System.in);
		int number = num.nextInt();
		
		int hint[] = getHint(answer, number);
		return hint;
	}
	
	/*
	 * 결과(힌트) 출력
	 * param : hint
	 * return : 
	 * hint의 값에 따라서 스트라이크 or 볼 or 낫싱 출력
	 * */
	public static void printHint(int[] hint) {
		String str = "";
		
		/* 스트라이크 출력 */
		if(hint[0] != 0) {
			str += hint[0] + " 스트라이크 ";
		}
		
		/* 볼 출력 */
		if(hint[1] != 0) {
			str += hint[1] + "볼";
		}
		
		/* 낫싱 출력 */
		if(hint[0] == 0 && hint[1] == 0) {
			str = "낫싱";
		}
		
		System.out.println(str);
	}
	
	/*
	 * 결과(힌트) 가져오기
	 * param : answer, number
	 * return : hint[]
	 * hint의 값을 모두 설정해 전달한다.
	 * */
	public static int[] getHint(int answer, int number) {
		int[] hint = new int[2];
		
		int ansarr[] = splitInt(answer);
		int numarr[] = splitInt(number);
		
		for(int i = 0 ; i < ansarr.length ; i++) {
			hint[0] += setHint(i,ansarr,numarr)[0];
			hint[1] += setHint(i,ansarr,numarr)[1];
		}
		return hint;
	}
	
	/*
	 * 정수 자릿수대로 나누기
	 * param : num
	 * return : number[]
	 * 자리마다 비교를 위해 자릿수대로 나누기
	 * */
	public static int[] splitInt(int num) {
		int[] number = new int[3];
		int divi = 100;
		for(int i = 0 ; i < number.length ; i++) {
			number[i] = num/divi;
			num = num%divi;
			divi = divi/10;
		}
		
		return number;
	}
	
	/*
	 * 결과(힌트) 설정
	 * param : i, ansarr[], numarr[]
	 * return : hint[]
	 * 스트라이크와 볼을 확인해 힌트변수를 설정.
	 * */
	public static int[] setHint(int i, int[] ansarr, int[] numarr) {
		int hint[] = new int[2];
		
		/* 스트라이크 설정 */
		if(ansarr[i] == numarr[i]) {
			hint[0] += 1;
		}
		
		/* 볼 설정 */
		for(int j = 0 ; j < ansarr.length ; j++) {
			if(i == j) {
				continue;
			}
			if(ansarr[i] == numarr[j]) {
				hint[1] += 1;
			}
		}
		
		return hint;
	}

}
