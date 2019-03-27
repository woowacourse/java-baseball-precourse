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
		Computer computer = new Computer();
		Player player = new Player();
		
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
	}
}
