package mypackage.minuyim.baseball.util;

import java.util.Scanner;

public class InputNumber {
	private Scanner sc = new Scanner(System.in);
	private int num;
	
	public int inputNumber(){
		num = sc.nextInt();
		return num;
	}
}