package baseball;

import java.util.Scanner;

import baseball.domain.BaseballNumbers;
import baseball.domain.Batter;
import baseball.domain.FixedNumbersGenerator;
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

    private final RoundResult roundResult;

    public BaseballGame(final Scanner scanner) {
        this.pitcher = new Pitcher();
        this.batter = new Batter(new RandomNumbersGenerator());
        this.roundResult = new RoundResult();
    }

    public void start() {
        boolean isEnd = false;
        while (!isEnd) {
            ScoreBoard scoreBoard = new ScoreBoard();
            while (!scoreBoard.isAnswer()) {
                BaseballNumbers pitchedNumbers = pitcher.pitches();
                batter.swing(pitchedNumbers);
                String result = roundResult.getResult(scoreBoard);
                System.out.println(result);
            }

            isEnd = pitcher.wantsToStop(new Scanner(System.in));
        }
    }
}
