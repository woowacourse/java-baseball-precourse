/*
 * Baseball
 * 
 * version 1.0
 * 
 * 2019. 3. 27
 * 
 * Created by Wongeun Song
 */

import java.util.Scanner;

public class Baseball {
	public void playBaseball() {
		do {
			this.playGame();
		} while(this.endOrRestart());
	}
	
	public void playGame() {
		Computer computer = new Computer();
		Player player = new Player();
		Result result;
		
		computer.generateNumbers();
		do {
			this.inputPlayerNumbers(player);
			result = this.compareNumbers(computer.numbers, player.numbers);
			result.print();
		} while (!result.isCollect());

		System.out.println("3개의 숫자를 맞추셧습니다! 게임종료");
	}
	
	public void inputPlayerNumbers(Player player) {
		do {
			player.inputNumbers();
			
			if (player.isCollectLength()) {
				player.convertStringToCharacter();
			} else {
				System.out.println("1-9까지 서로 다른 세개의 수를 입력하세요.");
				continue;
			}
			
			if (player.isNumber() && (!player.hasDuplicated())) {
				player.convertCharacterToInt();
			} else {
				System.out.println("1-9까지 서로 다른 세개의 수를 입력하세요.");
				continue;
			}
			break;
		} while(true);
	}
	
	public Result compareNumbers(int[] computerNumbers, int[] playerNumbers) {
		Result result = new Result();
		
		if (computerNumbers[0] == playerNumbers[0]) {
			result.increaseStrike();
		} else if (computerNumbers[0] == playerNumbers[1]) {
			result.increaseBall();
		} else if (computerNumbers[0] == playerNumbers[2]) {
			result.increaseBall();
		}
		
		if (computerNumbers[1] == playerNumbers[1]) {
			result.increaseStrike();
		} else if (computerNumbers[1] == playerNumbers[0]) {
			result.increaseBall();
		} else if (computerNumbers[1] == playerNumbers[2]) {
			result.increaseBall();
		}
		
		if (computerNumbers[2] == playerNumbers[2]) {
			result.increaseStrike();
		} else if (computerNumbers[2] == playerNumbers[0]) {
			result.increaseBall();
		} else if (computerNumbers[2] == playerNumbers[1]) {
			result.increaseBall();
		}
		
		return result;
	}
	
	public boolean endOrRestart() {
		Scanner scan = new Scanner(System.in);
		int select;
		
		while(true) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			select = scan.nextInt();
			
			if (select == 1) {
				return true;
			} else if (select == 2) {
				return false;
			}
		}
	}
	
}
