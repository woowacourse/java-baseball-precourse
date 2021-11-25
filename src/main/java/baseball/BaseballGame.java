package baseball;

import baseball.players.Computer;
import baseball.players.Player;

public class BaseballGame {
	private Computer computer;
	private Player player;
	private int ballCount;
	private int strikeCount;

	public BaseballGame() {
		this.computer = new Computer();
		this.player = new Player();
		this.ballCount = 0;
		this.strikeCount = 0;
	}

	public void run() {
		System.out.println("게임을 시작합니다.");
	}
}
