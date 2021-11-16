package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		int answer = RandomUtils.nextInt(100, 1000);
		boolean isFinish = false;
		String input;

		while (isFinish == false) {
			System.out.println("숫자를 입력해주세요 : ");
			input = scanner.nextLine();
			
			char[] charInput = input.toCharArray(); // input값을 char배열로

			String strAns = Integer.toString(answer);
			char[] charAns = strAns.toCharArray(); // ans값을 char 배열로
			
			// 확인
			System.out.println("인풋값 :");
			for(int i = 0; i <3; i ++) {
				System.out.printf("%c ", charInput[i]);
			}
			
			System.out.println("정답 :");
			for(int i = 0; i <3; i ++) {
				System.out.printf("%c ",charAns[i]);
			}//정답과 인풋 확인
			
			switch (hint(charInput, charAns)) {
			case 1 :
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				isFinish = true;
				break;
			case 2 :
				System.out.printf("%d스트라이크\n",strikeNum(charInput, charAns));
				break;
			case 3 :
				System.out.printf("%d볼 %d스트라이크 \n",ballNum(charInput, charAns), strikeNum(charInput, charAns));
				break;
			case 4 :
				System.out.printf("%d볼", ballNum(charInput, charAns));
				break;
			case 5 :
				System.out.println("낫싱");
				break;

			}

			// if 1 - (3개다맞힘)

			// if 2 - (스트라이크만 있는 경우)
			
			// if 3 - (볼, 스트라이크 둘다 있는 경우)

			// if 4 - (볼만 있는 경우)

			// if 5(낫싱)
		}

	}// end main

	public static int hint(char[] pCharInput, char[] pCharAns) {
		int count = 0;
		int hintVal = 0;
		char[] a = pCharInput;
		char[] b = pCharAns; // 입력하기 쉽게 짧게 바꿈

		for (int i = 0; i < 3; i++) {
			if (a[i] == b[i]) {
				count++;
			}
		}
		if (count == 3) {
			hintVal = 1;
		} // 3개 다 맞을경우 1을 반환

		if (count > 0 && count < 3) {
			if (isBall(a,b) == -1) {
				hintVal = 2;//스트라이크만 있을 경우 
			}
			
			if (isBall(a, b) == 1) {
				hintVal = 3; // 스트라이크 + ball
			};
		} // 스트라이크 존재할경우 ball까지 확인

		if (count == 0) {
			if (isBall(a,b) == -1) {
				hintVal = 5;
			} //스트라이크 0, ball 0이기에 바로 낫싱
			
			if (isBall(a,b) == 1) {
				hintVal = 4;
			}// ball만 잇는 경우
			
		}// 스트라이크x 볼 확인

		count = 0;

		return hintVal;

	} // end method hint

	public static int isBall(char[] pCharInput, char[] pCharAns) {
		char[] a = pCharInput;
		char[] b = pCharAns; // 입력하기 쉽게 짧게 바꿈
		int i = 0;
		int count = 0;
		int returnVal = 0;

		while (true) {

			if (i == 3) {
				break;
			}

			if (a[i] == b[0] && a[i] != b[i]) {
				count++;
			}

			if (a[i] == b[1] && a[i] != b[i]) {
				count++;
			}

			if (a[i] == b[2] && a[i] != b[i]) {
				count++;
			}

			i++;

		}

		if (count > 0) {
			returnVal = 1;
		}

		if (count == 0) {
			returnVal = -1;
		}

		return returnVal;
	}//end isBall
	
	public static int ballNum(char[] pCharInput, char[] pCharAns) {
		char[] a = pCharInput;
		char[] b = pCharAns; // 입력하기 쉽게 짧게 바꿈
		int i = 0;
		int count = 0;

		while (true) {

			if (i == 3) {
				break;
			}

			if (a[i] == b[0] && a[i] != b[i]) {
				count++;
			}

			if (a[i] == b[1] && a[i] != b[i]) {
				count++;
			}

			if (a[i] == b[2] && a[i] != b[i]) {
				count++;
			}

			i++;

		}

		return count;
	}// end ballNum
	
	public static int strikeNum (char[] pCharInput, char[] pCharAns) {
		int count = 0;
		char[] a = pCharInput;
		char[] b = pCharAns; // 입력하기 쉽게 짧게 바꿈
		
		for (int i = 0; i < 3; i++) {
			if (a[i] == b[i]) {
				count++;
			}
		}
		
		return count;
	}

}// end class Application
