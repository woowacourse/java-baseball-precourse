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
		} while (this.endOrRestart());
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
	
	/**
	 * 컴퓨터가 만들어낸 수와 플레이어가 예상한 수를 비교하는 메소드.
	 * 자리와 숫자가 일치하면 스트라이크, 숫자만 일치하면 볼의 카운트를 증가시켜 그 결과를 담은 Result 객체 반환
	 * @param computerNumbers 컴퓨터가 만들어낸 숫자
	 * @param playerNumbers 플레이어가 예상한 숫자
	 * @return 스트라이크와 볼의 개수를 담은 Result 객체
	 */
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
		
		while (true) {
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
