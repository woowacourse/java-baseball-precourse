package bassballPackage;

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

	}

}
