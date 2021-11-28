package baseball.domain;

import java.util.List;

public class Player {

    private Referee referee;
    private List<Integer> playerNumbers;
    private Hint hint;

    public Player(Referee referee) {
        this.referee = referee;
    }

    public void pickPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public void evaluateNumbers() {
        this.hint = referee.evaluateNumbers(this.playerNumbers);
    }

    public String getHintAsString() {
        return hint.toString();
    }

    public boolean isAllStrikes() {
        return hint.isAllStrikes();
    }

}
