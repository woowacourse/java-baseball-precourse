/*
 * Number Baseball
 * 
 * ver 1.0.0
 * 
 * November, 28th, 2019
 * 
 * Copyright(c)
 */

import java.util.*;

public class NumberBaseball {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int question = scanner.nextInt();
		ArrayList<Integer> answer = randomNumber(); 

		scanner.close();
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
