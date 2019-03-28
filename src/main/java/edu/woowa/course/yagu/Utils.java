package edu.woowa.course.yagu;

import java.util.Scanner;

/**
*@version 1.00 2019/03/28
*@author 조재훈
*/
public class Utils {
	private static Scanner scanner = new Scanner(System.in);

	public static int getInput() {
		int inputNum = -1;

		if(scanner.hasNextLine()) {
			String readLine = scanner.nextLine();
			try {
				inputNum = Integer.valueOf(readLine.trim());
			} catch (NumberFormatException e) {}
		}

		return inputNum;
	}

	public static void closeScanner() {
		scanner.close();
	}
}
