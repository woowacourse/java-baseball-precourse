package baseball;

public class BaseballGame {

	private Computer computer;

	protected BaseballGame() {
		this.computer = new Computer();
	}

	protected void startGame() {
		while(true) {
			computer.generateComputerRandomNum();
			System.out.println(computer.getComputermNum());
		}
	}
}
