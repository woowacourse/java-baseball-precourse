/*
 * Number Baseball
 * 
 * ver 1.0.0
 * 
 * November, 28th, 2019
 * 
 * Copyright(c) Hwangbo Kyeong 2019
 */

import java.util.*;

public class NumberBaseball {

	public static void main(String[] args) {
		ArrayList<Integer> answer = randomNumber(); 
		boolean isAnswer = false;

		while (true) {
			ArrayList<Integer> question = inputSlice();
			isAnswer = checkAnswer(answer, question);
			if(isAnswer == true) {				
				break;
			} else {}
		}
	}

	public static ArrayList<Integer> inputSlice() {
		ArrayList<Integer> question = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력해주세요 : ");
		int nums = scanner.nextInt();

		if(nums < 100 || nums > 999) {
			System.out.println("잘못된 입력입니다.");
			inputSlice();
		} else {
			question.add(nums/100);
			nums -= (nums/100) * 100;
			question.add(nums/10);
			nums -= (nums/10) * 10;
			question.add(nums);
		}

		return question;
	}

	public static boolean checkAnswer(ArrayList<Integer> answer, ArrayList<Integer> input) {
		int strike = 0;
		int ball = 0;

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(answer.get(i) == input.get(j)) {
					if(i == j) {
						strike += 1;
					} else {
						ball += 1;
					}
				}
			}
		}
		if(strike == 0 && ball == 0) {
			System.out.println("낫싱");
			return false;
		}
		else if(strike != 0 && ball == 0) {
			System.out.printf("%d 스트라이크\n", strike);
		}
		else if(strike == 0 && ball != 0) {
			System.out.printf("%d 볼\n", ball);
			return false;
		}
		else {
			System.out.printf("%d 스트라이크 %d 볼\n", strike, ball);
			return false;
		}
		if(strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			return true;
		} else
			return false;
	}
	public static boolean check(ArrayList<Integer> one, int two) {
		for(int i = 0; i < one.size(); i++) {
			if(one.get(i) == two) {
				return true;
			} else {
				continue;
			}
		}
		return false;
	}

	public static ArrayList<Integer> randomNumber() {
		Random ran = new Random();
		ArrayList<Integer> numbers = new ArrayList<>();
		int ten = ran.nextInt(9) + 1;
		int one = ran.nextInt(9) + 1;

		numbers.add(ran.nextInt(9) + 1);

		while(check(numbers, ten)) {
			ten = ran.nextInt(9) + 1;
		}

		numbers.add(ten);
		
		while(check(numbers, one)) {
			one = ran.nextInt(9) + 1;
		}

		numbers.add(one);

		return numbers;
	}
}
