package baseball;

import java.util.Scanner;

import baseball.domain.BaseballNumbers;
import baseball.domain.Batter;
import baseball.domain.Judgment;
import baseball.domain.Pitcher;
import baseball.domain.RandomNumbersGenerator;
import baseball.domain.RoundResult;
import baseball.domain.ScoreBoard;

public class BaseballGame {

    public static final String END = "2";

    public static final int BALLS_LENGTH = 3;

    private final Pitcher pitcher;

    private final Batter batter;

    private ScoreBoard scoreBoard;

    private final RoundResult roundResult;

    public BaseballGame(final Scanner scanner) {
        this.pitcher = new Pitcher();
        this.batter = new Batter(new RandomNumbersGenerator());
        scoreBoard = new ScoreBoard();
        this.roundResult = new RoundResult();
    }

    public void run() {
        boolean isGameEnd = false;
        while (!isGameEnd) {
            playGame();
            isGameEnd = pitcher.wantsToStop(new Scanner(System.in));
        }
    }

    private void playGame() {
        while (!scoreBoard.isAnswer()) {
            scoreBoard = new ScoreBoard();
            startRound();
            String result = roundResult.getResult(scoreBoard);
            System.out.println(result);
        }
    }

    private void startRound() {
        for (int numberIndex = 0; numberIndex < BALLS_LENGTH; numberIndex++) {
            int pitchedNumber = pitcher.pitch(numberIndex);
            Judgment judgment = batter.swing(numberIndex, pitchedNumber);
            scoreBoard.record(judgment);
        }
    }
}
