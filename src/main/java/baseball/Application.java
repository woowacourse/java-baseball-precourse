package baseball;

import java.util.Scanner;
import utils.randomGenerator;

public class Application {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO 구현 진행

		int randomNumber = randomGenerator.nextInt(100, 999);
		System.out.println(randomNumber);
		CheckInputNumber checkInputNumber = new CheckInputNumber();
		System.out.printf("세자리 숫자를 입력하시오 : ");
		String inputNum = scanner.nextLine();
		System.out.println(checkInputNumber.isValid(inputNum));

	}
}
