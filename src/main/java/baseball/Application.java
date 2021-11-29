package baseball;

public class Application {
	public static final int HUNDREDS_NUMBER = 0;
	public static final int TENS_NUMBER = 1;
	public static final int ONES_NUMBER = 2;

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
			application.printHint();
			application.checkThreeStrike();
			application.computer.setInitial();
			application.restartGame();
		}
	}

	public int getIntNumber(char eachNumber) {
		return eachNumber - '0';
	}

	public void countBall() {
		if (getIntNumber(player.getInputNumber(HUNDREDS_NUMBER)) == computer.getRandomNumber(ONES_NUMBER)
			|| getIntNumber(player.getInputNumber(HUNDREDS_NUMBER)) == computer.getRandomNumber(ONES_NUMBER)) {
			computer.addBall();
		}
		if (getIntNumber(player.getInputNumber(TENS_NUMBER)) == computer.getRandomNumber(HUNDREDS_NUMBER)
			|| getIntNumber(player.getInputNumber(TENS_NUMBER)) == computer.getRandomNumber(ONES_NUMBER)) {
			computer.addBall();
		}
		if (getIntNumber(player.getInputNumber(ONES_NUMBER)) == computer.getRandomNumber(HUNDREDS_NUMBER)
			|| getIntNumber(player.getInputNumber(ONES_NUMBER)) == computer.getRandomNumber(TENS_NUMBER)) {
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

	public void printHint() {
		if (computer.ball != 0) {
			System.out.print(computer.getBall() + "볼 ");
		}
		if (computer.strike != 0) {
			System.out.print(computer.getStrike() + "스트라이크");
		}
		if (computer.getBall() == 0 && computer.getStrike() == 0) {
			System.out.print("낫싱");
		}
		System.out.println();
	}

	public void printEndGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public void checkThreeStrike() {
		if (computer.getStrike() == Computer.NUMBER_SIZE) {
			continueGame = false;
			printEndGame();
		}
	}

	public void restartGame() {
		if (!continueGame) {
			if (player.scanRestartNumber()) {
				continueGame = true;
				computer.makeRandomNumber();
			}
		}
	}
}
