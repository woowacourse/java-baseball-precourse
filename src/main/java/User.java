package main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
	Scanner scanner = new Scanner(System.in);
	int input_num = 0;			// 유저에게 받을 값 정의. 기본값 0
	int[] result;			// 결과로 리턴 할 array 정의
	Userhelp userhelp = new Userhelp();
	
	public int[] input() {
		
		System.out.print("숫자를 입력해주세요 : ");
		try {
			
			input_num = scanner.nextInt();			// 유저에게 값을 받음
			
		} catch(InputMismatchException ime) {			// 문자를 포함한 값을 입력할 경우 예외처리
			
		    System.out.println("숫자만 입력 가능합니다.");
		    scanner = new Scanner(System.in);			// 스캐너 값 리셋 후 다시 받음
		    input();
		}
		
		int error_num = userhelp.exception(input_num);			// 에러 값 받기 (0-에러없음, 1,2-에러있음)
		
		
		if (error_num == 0) {			// 에러 없을 경우
			result = userhelp.num_to_arr(input_num);			// int 값을 array로 변경
			
		}else {			// 에러 있을 경우
			System.out.println("1~9로 이루어진 3자리 숫자만 입력 가능합니다.");
			scanner = new Scanner(System.in);			// 스캐너 값 리셋 후 다시 받음
			input();
		}
		return result;			// 유저 array 값 리턴
		
	}

}
