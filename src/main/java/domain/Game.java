package domain;

import java.util.List;
import utils.GameUtils;

public class Game {

    private List<Integer> answerNumbers;

    public Game() {}

    private void reset() {
        this.answerNumbers = GameUtils.generateAnswerNumberList();
    }

    public void start() {
        reset();

        //TODO: should be removed
        System.out.println("answer : " + this.answerNumbers);

        List<Integer> input = Player.getAnswerInput();

        int strikeCount = GameUtils.checkAnswerInput(input, this.answerNumbers);

        boolean isGameOver = GameUtils.checkGameOver(strikeCount);

        if (!isGameOver) return;

        boolean shouldRestart = Player.getGameRestartInput();
        if (shouldRestart) {
            start();
        }
    }
}
