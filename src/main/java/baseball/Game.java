package baseball;

public class Game {
	private Computer computer;
	private int strike;
	private int ball;

	public Game(Computer computer) {
		this.computer = computer;
		this.strike = 0;
		this.ball = 0;
	}
}
