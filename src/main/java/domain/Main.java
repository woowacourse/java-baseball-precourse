/*
 * Main class
 * 
 * version?
 * 
 * 2019-11-30
 * 
 * patent?
 */

package domain;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		User me = new User();
		Computer myComputer = new Computer();
		Scanner scanner = new Scanner(System.in);
		int newStart = 1;
		
		while(newStart == 1) {
			newGame(me, myComputer);
			System.out.println("게임을 시작하려면 1, 종료하려면 2를 입력하세요.");
			newStart = scanner.nextInt();
		}
	}
	
	private static void newGame(User player, Computer umpire) {
		umpire.generateNumbers();
		while(true) {
			player.enterNumbers();
			umpire.printGameResult(player.getNumbers());
			if(umpire.isGameOver(player.getNumbers())) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				break;
			}
		}
	}
}
