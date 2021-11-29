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

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }

    public boolean playGame(){
        List<Integer> input = User.inputNumber();

        hint.countHint(input, answerList);

        return hint.isThreeStrike();
    }

    private void reset(){
        this.correctAnswer = false;
        answerList = RandomUtils.RandomNumberList();
    }
}
