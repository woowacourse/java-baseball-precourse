package baseball;

import java.util.Scanner;

import utils.RandomUtils;

public class GameManager {
	private final static int START_INCLUSIVE = 100;
	private final static int END_INVLUSIVE = 999;
	
	private int answer;
	
	public String getNumber() {
		int random = RandomUtils.nextInt(START_INCLUSIVE, END_INVLUSIVE);
		
		
		return Integer.toString(random);
	}
	
	public void query() {
		final Scanner scanner = new Scanner(System.in);
		
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		this.answer = scanner.nextInt();
	}
	
	public int getQueryAnswer() {
		return this.answer;
	}
}
