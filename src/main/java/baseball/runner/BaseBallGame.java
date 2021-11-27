package baseball.runner;

import baseball.domain.vo.JudgementResult;
import baseball.domain.vo.number.Number;
import baseball.domain.vo.number.UniqueNumberFactory;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final Referee referee;

    public BaseBallGame(InputView inputView, OutputView outputView, Referee referee) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.referee = referee;
    }

    public void start() {

        do {
            playGame();
        } while (wantNewGame());

    }

    private void playGame() {
        Number enemyNumber = UniqueNumberFactory.create();

        do {
            Number playerNumber = inputView.guessNumber();
            JudgementResult result = referee.judge(enemyNumber, playerNumber);
            outputView.printResult(result);
        } while (!referee.isGameOver());

        outputView.gameOver();
    }

    private boolean wantNewGame() {
        return inputView.wantNewGame();
    }

}
