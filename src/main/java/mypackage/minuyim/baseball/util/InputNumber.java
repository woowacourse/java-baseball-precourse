package mypackage.minuyim.baseball.util;

import java.util.Scanner;

public class InputNumber {
	private Scanner sc = new Scanner(System.in);
	private int num;
	
	public int inputNumber(){
		System.out.print("숫자를 입력해주세요 : ");
		num = sc.nextInt();
		return num;
	}
}