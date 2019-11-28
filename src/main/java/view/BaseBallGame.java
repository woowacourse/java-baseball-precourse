package view;

import baseball.BaseBalls;
import baseball.generator.RandomBallGenerator;
import computer.Computer;
import computer.Flag;
import computer.result.Results;

import java.util.List;

public class BaseBallGame {
    private Computer computer;
    private Flag flag;

    private BaseBallGame() {
        this.computer = Computer.newGame(new RandomBallGenerator());
        this.flag = Flag.init();
    }

    public static BaseBallGame init() {
        return new BaseBallGame();
    }

    public boolean runnable() {
        return flag.isRunnable();
    }

    public boolean pitch() {
        List<Integer> numbers = InputView.inputNumbers();
        Results results = computer.getResults(new BaseBalls(numbers));
        OutputView.showResult(results);
        return results.isOut();
    }

    public void updateGame(boolean isOut) {
        if (isOut) {
            OutputView.showGoalComment();
            this.flag = new Flag(InputView.inputContinueFlag());
            computer = Computer.newGame(new RandomBallGenerator());
        }
    }

}
