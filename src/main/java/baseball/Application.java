package baseball;

public class Application {
	public Computer computer;
	public Player player;
	public boolean continueGame;

	public Application(Computer computer, Player player) {
		this.computer = computer;
		this.player = player;
		this.continueGame = true;
	}

	public static void main(String[] args) {
		Computer computer = new Computer();
		Player player = new Player();
		Application application = new Application(computer, player);
		application.computer.makeRandomNumber();
		while (application.continueGame) {
			application.player.scanInputNumber();
		}
	}
}
