package src.main.java;

import java.util.Scanner;

public class User {
	
	/**
	 * 3자리 수를 각각의 자리수에 따라 분리한다
	 * ex) 123 -> 1, 2, 3
	 * @param num 	3자리 수
	 * @return res 	자리 수에 따른 분리된 수
	 */
	public static int[] splitNum(int num) {
		
		int[] res = new int[3];
		
		res[0] = num / 100;
		num = num % 100;
		
		res[1] = num / 10;
		num = num % 10;
		
		res[2] = num;
		
		return res;
	}
	
	public static boolean isNumber(String input) {
		boolean is_num;
		is_num = true;
		
		try {
			Double.parseDouble(input);
		} catch (Exception e){
			System.out.println(e);
			is_num = false;
		}
		return is_num;
	}
	
	/**
	 * String input이 valid한지 검사한다
	 * 1. 3자리인지
	 * 2. 숫자인지
	 * 3. 서로 다른 수인지
	 * @param input
	 * @return
	 */
	public static boolean isValidInput(String input) {
		boolean valid;
		
		valid = true;
		//3자리가 아닐 경우
		if(input.length() != 3) 
			valid = false;
		
		//숫자가 아닐 경우
		if(!isNumber(input)) 
			valid = false;
		
		//중복된 숫자가 포함될 경우
		if(input.charAt(0) == input.charAt(1)) valid = false;
		else if (input.charAt(0) == input.charAt(2)) valid = false;
		else if (input.charAt(1) == input.charAt(2)) valid = false; 
		
		return valid;
	}
	
	/**
	 * 게임 플레이어는 3개의 숫자를 입력한다
	 * @return
	 */
	public static int[] input() {
		
		String str;
		int input_num;
		int[] split_num = new int[3];
		
		//입력 검증
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("숫자를 입력해주세요 : ");
			str = sc.nextLine();
			if(isValidInput(str)) break;
			
			System.out.println("서로 다른 3자리의 수를 입력하세요");
		}
		input_num = Integer.parseInt(str);
		
		//입력한 숫자를 분리
		split_num = splitNum(input_num);
		
		return split_num;
	}
}
