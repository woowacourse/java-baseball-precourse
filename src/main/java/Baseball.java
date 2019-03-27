/*
 * Baseball
 * 
 * version 1.0
 * 
 * 2019. 3. 27
 * 
 * Created by Wongeun Song
 */
public class Baseball {
	public static void main(String[] args) {
		Baseball baseball = new Baseball();
		Computer computer = new Computer();
		Player player = new Player();
		Result result;
		
		computer.generateNumbers();
		do {
			player.inputNumbers();
			
			if (player.isCollectLength()) {
				player.convertStringToCharacter();
			} else {
				System.out.println("1-9까지 서로 다른 세개의 수를 입력하세요.");
				continue;
			}
			
			if (player.isNumber() && !player.hasDuplicated()) {
				player.convertCharacterToInt();
			} else {
				System.out.println("1-9까지 서로 다른 세개의 수를 입력하세요.");
				continue;
			}
			break;
		} while(true);
		
		result = baseball.compareNumbers(computer.numbers, player.numbers);
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
}
