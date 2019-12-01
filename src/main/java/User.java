package main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
	Scanner scanner = new Scanner(System.in);
	int input_num = 0;
	int[] result;
	Userhelp userhelp = new Userhelp();
	
	public int[] input() {
		
		System.out.print("숫자를 입력해주세요 : ");
		try {
			
			input_num = scanner.nextInt();
			
		} catch(InputMismatchException ime) {
			
		    System.out.println("숫자만 입력 가능합니다.");
		    scanner = new Scanner(System.in);
		    input();
		}
		
		int error_num = userhelp.exception(input_num);
		
		
		if (error_num == 0) {
			result = userhelp.num_to_arr(input_num);
			
		}else {
			System.out.println("1~9로 이루어진 3자리 숫자만 입력 가능합니다.");
			scanner = new Scanner(System.in);
			input();
		}
		return result;
		
	}

}
