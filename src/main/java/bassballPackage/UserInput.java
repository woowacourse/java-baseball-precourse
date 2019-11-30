package bassballPackage;

import java.util.InputMismatchException; //예외처리위해 필요.
import java.util.Scanner; //사용자 입력위해 필요.

public class UserInput {
	static int[] userInput(){
		int[] result = new int[4];
		Scanner input = new Scanner(System.in);			//이거 close해야될 것 같은데 어떻게 해야 할 지 모르겠다.(20줄 주석)
		String introTxt = "사용자 입력: 1 ~ 9 사이의 서로다른 정수로 이루어진 세자리 수를 입력하세요 :";
		System.out.println(introTxt);
		
		int initial = input.nextInt();		//사용자입력
		
		result[0] = initial;
		result[1] = initial / 100;
		result[2] = (initial % 100) / 10;
		result[3] = initial % 10;
		System.out.println("사용자 입력: " + initial + "을 입력하였습니다.");
//		input.close();
		return result;
	}
	
	static int[] userInputValid() {
		while (true) {
			try {
				return userInput();
			} catch(InputMismatchException ime) {
				System.out.println("잘못된 입력: 정수를 입력하세요.");
				continue;
			}
		}
	}
	
	static int[] userInputValid2() {			//자릿 수 검사
		while (true) {
			int[] result = userInputValid();
			if (result[0] >= 1000 || result[0] < 100) {
				System.out.println("잘못된 입력: 세자리 수를 입력하세요.");
			} else if (result[2] == 0 || result[3] == 0) {
				System.out.println("잘못된 입력: 1~9 사이 수를 입력하세요.");
			} else if (result[1] == result[2] || result[1] == result[3] || result[2] == result[3]) {
				System.out.println("잘못된 입력: 서로 다른 세 수를 입력하세요.");
			} else {
				return result;
			}
		}
	}
	
	public static void main(String[] args) {
		//userInput메서드 테스트
//		int[] result1 = userInput();
//		System.out.println("결괏값 백의자리 수:" + result1[1]);
//		System.out.println("결괏값 십의자리 수:" + result1[2]);
//		System.out.println("결괏값 일의자리 수:" + result1[3]);
		
		//userInputValid메서드 테스트
//		int[] result1 = userInputValid();
//		System.out.println("결괏값 백의자리 수:" + result1[1]);
//		System.out.println("결괏값 십의자리 수:" + result1[2]);
//		System.out.println("결괏값 일의자리 수:" + result1[3]);
		
		int[] result2 = userInputValid2();
		System.out.println("결괏값 :" + result2[0]);
	}
}

