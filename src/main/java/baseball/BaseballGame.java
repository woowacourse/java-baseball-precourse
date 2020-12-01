package baseball;

import utils.NumbersFactory;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class BaseballGame {
    private final Scanner scanner;

    private boolean isGameEnd = false;

    public BaseballGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        final Numbers target = NumbersFactory.createRandomNumbers();

        do {
            Numbers guess = InputView.getNumbers(scanner);
            Score score = calculateScore(target, guess);
            OutputView.printScore(score);
            checkGameOver(score);
        } while (!isGameEnd);

        OutputView.printGameOver();
    }

    private Score calculateScore(Numbers target, Numbers guess) {
        int strikeCnt = GameRule.countStrike(target, guess);
        int ballCnt = GameRule.countBall(target, guess);

        return new Score(strikeCnt, ballCnt);
    }

    private void checkGameOver(Score score) {
        isGameEnd = GameRule.checkGameEnd(score);
    }
}
