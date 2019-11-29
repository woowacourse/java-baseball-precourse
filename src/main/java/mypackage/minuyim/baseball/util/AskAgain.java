package mypackage.minuyim.baseball.util;

import java.util.Scanner;

public class AskAgain {
	private int num;
	
	public int askAgain() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		while (true) {
			while (!sc.hasNextInt()) {
				sc.next();
				System.out.println("숫자를 입력하세요.");
			}
			num = sc.nextInt();
			if (num != 1 && num != 2) {
				System.out.println("올바른 숫자를 입력하세요.");
			} else {
				break;
			}
		}
		return num;
		}
}