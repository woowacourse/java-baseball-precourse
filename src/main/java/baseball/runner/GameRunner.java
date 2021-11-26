package baseball.runner;

import baseball.domain.vo.BallStrikeCount;
import baseball.domain.Computer;
import baseball.domain.vo.number.Number;
import baseball.domain.vo.number.UniqueNumberFactory;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameRunner {

    private final InputView inputView;
    private final OutputView outputView;
    private Computer computer;

    public GameRunner(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        do {
            newGame();
            playGame();
            exitGame();
        } while (wantNewGame());

    }

    private boolean wantNewGame() {
        return inputView.wantNewGame();
    }

    private void exitGame() {
        outputView.exitGame();
    }

    private void newGame() {
        Number computerNumber = UniqueNumberFactory.create();
        computer = new Computer(computerNumber);
    }

    private void playGame() {
        while (true) {
            Number playerNumber = inputView.guessNumber();
            BallStrikeCount result = computer.countBallStrike(playerNumber);
            outputView.printResult(result);
            if (result.isThreeStrike()) {
                return;
            }
        }
    }

}
