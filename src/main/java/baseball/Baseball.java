package baseball;

public class Baseball {	
	
	public static void start() {
		GameManager manager = new GameManager();
		Player player = new Player();
		
		String playerNumber;
		
		do {
			player.input();
			playerNumber = player.getNumber();
			manager.inspect(playerNumber);
		} while(!manager.randomNumber.equals(playerNumber));
		
		restart(manager);
	}
	
	private static void restart(GameManager manager) {
		manager.query();
		if (manager.getQueryAnswer() == 1) {
			start();
		} else {
			System.out.println("게임을 종료합니다.");
		}
	}
}
