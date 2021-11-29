package baseball.game;

import baseball.utils.RandomUtils;

import java.util.List;

public class Game {

    private boolean correctAnswer;
    private List<Integer> answerList;

    public Game() {
        this.correctAnswer = false;
        answerList = RandomUtils.RandomNumberList();
    }

    public void start() {
        while (!this.correctAnswer) {
            this.correctAnswer = this.playGame();
        }
    }

    public boolean playGame(){
        List<Integer> input = User.inputNumber();

        return true;
    }
}
