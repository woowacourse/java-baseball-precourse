package baseball.domain;

import baseball.utils.RandomNumberList;

import java.util.List;

public class Game {

    private List<Integer> answerList;
    private boolean isOver = false;

    public Game() {
        reset();
    }

    private void reset() {
        this.answerList = RandomNumberList.generate();
        this.isOver = false;
    }

    public void start() {
        while (!this.isOver) {
            isOver = this.play();
        }

        boolean shouldRestart = Player.getGameRestartInput();
        if (shouldRestart) {
            reset();
            start();
        }
    }

    private boolean play() {
        List<Integer> input = Player.getAnswerInput();

        String hint = Judge.checkAnswerInput(input, this.answerList);

        return Judge.checkGameOver(hint);
    }
}
