package bassballPackage;

import java.util.InputMismatchException; //예외처리위해 필요.
import java.util.Scanner; //사용자 입력위해 필요.

public class UserInput {
	static int[] userNumArr;
	
	static int[] userInput(){
		int[] result = new int[4];
		Scanner input = new Scanner(System.in);			//이거 close해야될 것 같은데 어떻게 해야 할 지 모르겠다.(20줄 주석)
		
		String tmpTxt = "사용자 입력: 1 ~ 9 사이의 서로다른 정수로 이루어진"
				+ " 세자리 수를 입력하세요 :";
		System.out.println(tmpTxt);
		
		int initial = input.nextInt();		//사용자입력
		
		result[0] = initial;
		result[1] = initial / 100;
		result[2] = (initial % 100) / 10;
		result[3] = initial % 10;
		
		String tmpTxt2 = "사용자 입력: " + initial + "을 입력하였습니다.";
		System.out.println(tmpTxt2);
		
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
				String tmpTxt = "잘못된 입력: 세자리 수를 입력하세요.";
				System.out.println(tmpTxt);
			} else if (result[2] == 0 || result[3] == 0) {
				String tmpTxt = "잘못된 입력: 1~9 사이 수를 입력하세요.";
				System.out.println(tmpTxt);
			} else if (result[1] == result[2] 
					|| result[1] == result[3] 
					|| result[2] == result[3]) {
				String tmpTxt = "잘못된 입력: 서로 다른 세 수를 입력하세요.";
				System.out.println(tmpTxt);
			} else {
				return result;
			}
		}
	}
}

