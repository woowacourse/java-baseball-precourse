package week1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//indent 2이하로 작성
public class Baseball {
	static int[] comNums = new int[3];
	static int[] userNums = new int[3];

	static int strike = 0;
	static int ball = 0;
	static int tryCount = 0;
	
	static Scanner sc = new Scanner(System.in);
	
	// comNums 생성
	public static int[] makeComNums() {
		// List를 shuffle() 메소드로 섞음
		List<Integer> comNum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(comNum);
		
		// 섞인 List를 Array로 변환
		for (int i = 0; i < 3; i++) {
			comNums[i] = comNum.get(i);
		}
		
		return comNums;
	}
	
	// userNum 생성
	public static int[] makeUserNums() {
		
		System.out.println("<Player 숫자입력>");
		System.out.println("1에서 9까지 서로 다른 숫자 3개를 입력하세요 - ex)123, 456, 789");
		int inputNum = sc.nextInt();
		
		for (int i = 2; i >= 0; i--) {
			userNums[i] = inputNum%10;
			inputNum /= 10;
		}
		
		// 중복체크
		if(userNums[0]==userNums[1]||userNums[1]==userNums[2]||userNums[2]==userNums[0]) {
			System.out.println("서로 다른 숫자 입력을 부탁드립니다.");
			System.out.println();
			userNums = makeUserNums();
		}
		
		return userNums;
	}
	
	// 볼 판정
	public static void strikeOrBall(int comNum, int userNum, int i, int j) {
		if(comNum == userNum && i==j) {
			strike++;
		}else if(comNum == userNum && i!=j) {
			ball++;
		}
	}
	
	// 판정 선언(심판)
	public static void judge(int[] comNums, int[] userNums) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				strikeOrBall(comNums[i],userNums[j],i,j);
			}
		}
		
		System.out.println();
		System.out.println("<심판 판정>");
		System.out.println(strike +":스트라이크 | " + ball + ":볼!!!");
		if(strike==0 && ball==0) {
			System.out.println("낫싱!");
		}
		System.out.println();
	}
	
	// 게임진행과 재시작
	public static void main(String[] args) {   
			
		// 게임진행
		comNums = makeComNums(); // comNums 생성
		System.out.println("<ComNums 확인>");
		for (int c : comNums) {
			System.out.print(c);
		}
		System.out.println();
		System.out.println();
			
		while(strike<3) { 
			strike=0;
			ball=0;
			tryCount++;
			userNums = makeUserNums();
			judge(comNums, userNums); 
		}
			
		System.out.println("<결과>");
		System.out.println("총 "+tryCount+"회만에 정답!");
		System.out.println();
			
		// 재시작
		System.out.println("<안내>");
		System.out.println("게임 다시 시작(1 입력)or종료(1을 제외한 숫자 입력)");
		int onOff = sc.nextInt();
		System.out.println();
			
		if(onOff == 1) { 
			System.out.println("[Play Ball!]");
			System.out.println();
			strike = 0; // 초기화
			ball = 0;
			tryCount = 0;
			main(args);
		}
			
		// 종료
		System.out.println("<종료>");
		System.out.println("다음에 또 봐요 :)");
		
		sc.close();
		System.exit(0);
	}

}