package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO 구현 진행
		char[] randomNumbersArray = new char[3];
		boolean[] already = new boolean[10];
		final int START_INCLUSIVE = 1;
		final int END_INCLUSIVE = 9;
		int strike;
		int ball;
		
		for (int i =0; i < already.length; i ++) {
			already[i] = false;
		}
		
		
		int count = 0;
		
		while (count < 3) {
			int randomNumbers = utils.RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
			if (!already[randomNumbers]) {
				randomNumbersArray[count] = Integer.toString(randomNumbers).charAt(0);
				already[randomNumbers] = true;
				count++;
			}
		}
		
		boolean finish = false;
		
		while (!finish) {
			strike = 0;
			ball = 0;
			System.out.println("1~9까지의 정수를 입력하세요.");
			String UserInputNumbers = scanner.next();
			char[] userInputNumbersArray = UserInputNumbers.toCharArray();
			
			for (int i = 0; i < 3; ++i) {
				for (int j = 0; j < 3; ++j) {
					if (userInputNumbersArray[i] == randomNumbersArray[j]) {
						if(i == j) {strike++;}
						else ball++;
					}
				}
			}
			
			System.out.println(strike + " 스트라이크" + ball + "볼");
			if (strike == 3) {
				System.out.println("축하합니다!");
				finish =true;
			}
		}
		scanner.close();
		
	}
}
