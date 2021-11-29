package baseball.service;

import java.util.List;

import baseball.domain.Player;
import baseball.domain.Referee;

public class BaseballService {

	private final Referee referee;
	private final Player player;

	public BaseballService() {
		this.referee = new Referee();
		this.player = new Player(referee);
	}

	public void init() {
		referee.pickRandomNumbers();
	}

	public String playGame(List<Integer> playerNumbers) {
		player.pickPlayerNumbers(playerNumbers);
		player.evaluateNumbers();
		return player.getHintAsString();
	}

	public boolean isGameCleared() {
		return player.isAllStrikes();
	}

}
