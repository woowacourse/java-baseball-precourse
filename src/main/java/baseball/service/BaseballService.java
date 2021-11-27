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

    public void pickRefereeNumbers() {
        referee.pickRandomNumbers();
    }

    public String evaluate(List<Integer> playerNumbers) {
        player.pickPlayerNumbers(playerNumbers);
        player.evaluateNumbers();
        return player.getHint().toString();
    }

    public boolean isGameCleared() {
        return player.getHint().isAllStrikes();
    }
}
