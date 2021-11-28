package baseball.model.Referee;

import baseball.constant.Constant;

public class Referee {
    private final Hint hint;

    public Referee() {
        hint = new Hint();
    }

    public int[] getHint(String answerNumber, String playerNumber) {
        return hint.getHint(answerNumber, playerNumber);
    }

    public boolean isThreeStrike() {
        if (hint.getStrike() == Constant.GAME_SET_STRIKE_VALUE) {
            return true;
        }
        return false;
    }
}
