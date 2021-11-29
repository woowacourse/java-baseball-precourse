package baseball.game;

import baseball.utils.RandomUtils;

import java.util.List;

public class Game {
    private boolean correctAnswer;
    private List<Integer> answerList;
    private Hint hint;

    public Game() {
        this.correctAnswer = false;
        answerList = RandomUtils.RandomNumberList();
        hint = new Hint();
    }

    public void start() {
        while (!this.correctAnswer) {
            this.correctAnswer = this.playGame();
        }

        System.out.println(Constant.WIN_MESSAGE);

        if (User.isGameRestart()) {
            reset();
            start();
        }
    }

    public boolean playGame() {
        List<Integer> input = User.inputNumber();
        hint.countHint(input, answerList);

        return hint.isThreeStrike();
    }

    private void reset() {
        this.correctAnswer = false;
        answerList = RandomUtils.RandomNumberList();
    }
}
