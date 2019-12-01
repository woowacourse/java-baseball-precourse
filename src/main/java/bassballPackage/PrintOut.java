package bassballPackage;

import java.util.InputMismatchException;
import java.util.Scanner; //newGameQuery에서 사용자 입력위해 필요.
import bassballPackage.CpuInput;

public class PrintOut {
	static void printOut(int[] resultArr) {
		int strike = resultArr[0];
		int ball = resultArr[1];
		if (strike == 0 && ball == 0) {
			System.out.println("결과: 낫싱");
		} else if (strike == 3) {
			System.out.println("결과 :" + strike + " 스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			newGameQuery();
		} else if (strike == 0) {
			System.out.println("결과: " + ball + " 볼");
		} else if (ball == 0) {
			System.out.println("결과: " + strike + " 스트라이크");
		} else {
			System.out.println("결과: " + strike + " 스트라이크 " + ball + " 볼");
		}
	}
	
//	//사용자입력 유효성검사 기능이 없는 코드.
//	static void newGameQuery() {
//		Scanner input = new Scanner(System.in);
//		System.out.println("새 게임을 시작하려면 1, 프로그램을 종료하려면 2를 입력하세요.");
//		int userInput = input.nextInt(); //사용자 입력
//		
//		if (userInput == 1) {
//			System.out.println("사용자 입력: " + userInput);
//			System.out.println("새 게임을 시작합니다.");
//			//새 게임 시작위해서 컴퓨터 세 자리수 초기화를 위해서 cpuInput 메서드 호출해야할 자리.
//			CpuInput.cpuNumArr = CpuInput.cpuInput();
//		} else if (userInput == 2) {
//			System.out.println("사용자 입력: " + userInput);
//			System.out.println("게임을 종료합니다.");
//			System.exit(0);
//		}
//	}
	
	static void newGameQuery() {
		int userInput = 0;
		while(true) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("새 게임을 시작하려면 1, 프로그램을 종료하려면 2를 입력하세요.");
				userInput = input.nextInt(); //사용자 입력
				break;
			} catch(InputMismatchException ime) {
				System.out.println("잘못된 입력: 정수를 입력하세요.");
			}
		}
		
		if (userInput != 1 && userInput != 2) {
			System.out.println("잘못된 입력: 1 혹은 2를 입력하세요.");
			newGameQuery();
		} else if(userInput == 1) {
			System.out.println("사용자 입력: " + userInput);
			System.out.println("새 게임을 시작합니다.");
			CpuInput.cpuNumArr = CpuInput.cpuInput();
		} else if(userInput == 2) {
			System.out.println("사용자 입력: " + userInput);
			System.out.println("게임을 종료합니다.");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		// printOut test
//		int[] test1 = {0,0};
//		int[] test2 = {0,1};
//		int[] test3 = {0,2};
//		int[] test4 = {0,3};
//		int[] test5 = {1,0};
//		int[] test6 = {2,0};
//		int[] test7 = {1,1};
//		int[] test8 = {1,2};
//		int[] test9 = {3,0};
//		printOut(test1);
//		printOut(test2);
//		printOut(test3);
//		printOut(test4);
//		printOut(test5);
//		printOut(test6);
//		printOut(test7);
//		printOut(test8);
//		printOut(test9);

		//newGameQuery test
//		newGameQuery();
		
		//testQuery test
		newGameQuery();
	}

}
