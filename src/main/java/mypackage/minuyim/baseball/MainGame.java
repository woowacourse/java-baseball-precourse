package mypackage.minuyim.baseball;

import mypackage.minuyim.baseball.util.*;

public class MainGame {
	private static final int TARGET_NUMBER = 3;
	
	private static void Onegame(int[] answerNumbers) {
		int userNumber;
		int[] userNumbers;
		
		while (true) {
			InputNumber inputNumber = new InputNumber();
			userNumber = inputNumber.inputNumber();
			
			ConvertToArray convertNumber = new ConvertToArray();
			userNumbers = convertNumber.convertToArray(userNumber);
			
			MakeHint hint = new MakeHint(answerNumbers, userNumbers);
			
			PrintHint print = new PrintHint();
			print.printHint(hint.strike, hint.ball);
			
			if (hint.strike == TARGET_NUMBER) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				break;
			}
		}

		return;
	}
	
	public static void main(String[] args) {
		int[] answerNumbers;
		
		MakeRandomNumber makeRandomNumber = new MakeRandomNumber();
		answerNumbers = makeRandomNumber.makeRandom();
		
		Onegame(answerNumbers);

		return;
	}
}