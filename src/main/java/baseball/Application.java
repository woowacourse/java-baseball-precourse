package playBaseBall;

import java.util.Scanner;
import playBaseBall.RandomUtils;

public class Application {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO 구현 진행
		CheckDuplicate checkDuplicate = new CheckDuplicate();
		int randomNum = CheckDuplicate.makeRandomNumber();
		//System.out.println(randomNum);
		
		
		//System.out.println(randomNumber);
		CheckInputNumber checkInputNumber = new CheckInputNumber();
		System.out.printf("세자리 숫자를 입력하시오 : ");
		String inputNum = scanner.nextLine();
		//System.out.println(checkInputNumber.isValid(inputNum));

	}
	
	
}
