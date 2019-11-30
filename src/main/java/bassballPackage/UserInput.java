package bassballPackage;

import java.util.InputMismatchException; //예외처리위해 필요.
import java.util.Scanner; //사용자 입력위해 필요.

public class UserInput {
	static int[] userInput(){
		int[] result = new int[3];
		Scanner input = new Scanner(System.in);
		String introTxt = "사용자 입력: 1 ~ 9 사이의 서로다른 정수로 이루어진 세자리 수를 입력하세요 :";
		System.out.println(introTxt);
		
		int initial = input.nextInt();		//사용자입력
		
		result[0] = initial / 100;
		result[1] = (initial % 100) / 10;
		result[2] = initial % 10;
		System.out.println("사용자 입력: " + initial + "을 입력하였습니다.");
//		input.close();
		return result;
	}
	
	static int[] userInputValid() {
		while (true) {
			try {
				return userInput();
			} catch(InputMismatchException ime) {
				System.out.println("잘못된 입력");
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		//userInput메서드 테스트
//		int[] result1 = userInput();
//		System.out.println("결괏값 백의자리 수:" + result1[0]);
//		System.out.println("결괏값 십의자리 수:" + result1[1]);
//		System.out.println("결괏값 일의자리 수:" + result1[2]);
		
		//userInputValid메서드 테스트
		int[] result1 = userInputValid();
		System.out.println("결괏값 백의자리 수:" + result1[0]);
		System.out.println("결괏값 십의자리 수:" + result1[1]);
		System.out.println("결괏값 일의자리 수:" + result1[2]);
	}
}

