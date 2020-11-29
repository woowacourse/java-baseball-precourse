package baseball;

import java.util.Scanner;

import baseball.domain.Batter;
import baseball.domain.Judgment;
import baseball.domain.Pitcher;
import baseball.domain.ScoreBoard;
import baseball.domain.generator.NumbersGenerator;
import baseball.domain.generator.RandomNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

    public static final String GAME_END = "2";

    public static final int BALLS_LENGTH = 3;

    protected final InputView inputView;

    protected Batter batter;

    protected Pitcher pitcher;

    protected ScoreBoard scoreBoard;

    protected final OutputView outputView;

    public BaseballGame(final Scanner scanner) {
        this(scanner, new RandomNumbersGenerator());
    }

    public BaseballGame(final Scanner scanner, final NumbersGenerator generator) {
        this.inputView = new InputView(scanner);
        this.batter = new Batter(generator);
        this.scoreBoard = new ScoreBoard();
        this.outputView = new OutputView();
    }

    public void run() {
        boolean isGameEnd = false;
        while (!isGameEnd) {
            setGame();
            playGame();
            isGameEnd = inputView.askRetry();
        }
    }

    public void setGame() {
        batter = batter.setNewAnswer();
        scoreBoard = new ScoreBoard();
    }

    private void playGame() {
        while (!scoreBoard.isAnswer()) {
            setRound(inputView.askBallNumbers());
            startRound();
            outputView.printResult(scoreBoard);
        }
    }

    protected void setRound(String ballNumbers) {
        scoreBoard = new ScoreBoard();
        pitcher = new Pitcher(ballNumbers);
    }

    protected void startRound() {
        for (int numberIndex = 0; numberIndex < BALLS_LENGTH; numberIndex++) {
            final int pitchedNumber = pitcher.pitch(numberIndex);
            final Judgment judgment = batter.swing(numberIndex, pitchedNumber);
            scoreBoard.record(judgment);
        }
    }
}
