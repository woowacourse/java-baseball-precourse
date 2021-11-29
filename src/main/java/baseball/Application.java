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
			application.countBall();
			application.countStrike();
		}
	}

	public int getIntNumber(char eachNumber) {
		return eachNumber - '0';
	}

	public void countBall() {
		if (getIntNumber(player.getInputNumber(0)) == computer.getRandomNumber(1)
			|| getIntNumber(player.getInputNumber(0)) == computer.getRandomNumber(2)) {
			computer.addBall();
		}
		if (getIntNumber(player.getInputNumber(1)) == computer.getRandomNumber(0)
			|| getIntNumber(player.getInputNumber(1)) == computer.getRandomNumber(2)) {
			computer.addBall();
		}
		if (getIntNumber(player.getInputNumber(2)) == computer.getRandomNumber(0)
			|| getIntNumber(player.getInputNumber(2)) == computer.getRandomNumber(1)) {
			computer.addBall();
		}
	}

	public void countStrike() {
		for (int i = 0; i < Computer.NUMBER_SIZE; i++) {
			if (computer.getRandomNumber(i) == getIntNumber(player.getInputNumber(i))) {
				computer.addStrike();
			}
		}
	}
}
