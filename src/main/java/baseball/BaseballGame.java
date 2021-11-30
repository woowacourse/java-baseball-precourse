package baseball;

public class BaseballGame {
	Player player;
	Computer computer;

	BaseballGame() {
		this.player = new Player();
		this.computer = new Computer();
	}

	public void start() {
		do {
			play();
		} while (player.wantRestart());
	}

	public void play() {
		computer.generateRandomNumber();
		do {
			computer.countScore(player.getPlayerInputNum());
			computer.printScore();
		} while (!computer.isGameOver());
	}
}
