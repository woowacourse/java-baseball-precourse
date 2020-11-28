package baseball;

import java.util.Scanner;

import baseball.domain.Batter;
import baseball.domain.Judgment;
import baseball.domain.Pitcher;
import baseball.domain.RandomNumbersGenerator;
import baseball.domain.RoundResult;
import baseball.domain.ScoreBoard;

public class BaseballGame {

    public static final String GAME_END = "2";

    public static final int BALLS_LENGTH = 3;

    private final InputView inputView;

    private final Batter batter;

    private Pitcher pitcher;

    private ScoreBoard scoreBoard;

    private final RoundResult roundResult;

    public BaseballGame(final Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.batter = new Batter(new RandomNumbersGenerator());
        scoreBoard = new ScoreBoard();
        this.roundResult = new RoundResult();
    }

    public void run() {
        boolean isGameEnd = false;
        while (!isGameEnd) {
            playGame();
            isGameEnd = pitcher.wantsToStop(inputView.askRetry());
        }
    }

    private void playGame() {
        while (!scoreBoard.isAnswer()) {
            setRound();
            startRound();
            printRoundResult();
        }
    }

    private void setRound() {
        scoreBoard = new ScoreBoard();

        String balls = inputView.askBallNumbers();
        pitcher = new Pitcher(balls);
    }

    private void startRound() {
        for (int numberIndex = 0; numberIndex < BALLS_LENGTH; numberIndex++) {
            int pitchedNumber = pitcher.pitch(numberIndex);
            Judgment judgment = batter.swing(numberIndex, pitchedNumber);
            scoreBoard.record(judgment);
        }
    }

    private void printRoundResult() {
        String result = roundResult.getResult(scoreBoard);
        System.out.println(result);
    }
}
