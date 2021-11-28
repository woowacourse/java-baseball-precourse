package baseball.model.Referee;

public class Referee {
    private final Hint hint;

    public Referee() {
        hint = new Hint();
    }

    public int[] getHint(String answerNumber, String playerNumber){
        return hint.getHint(answerNumber, playerNumber);
    }
}
