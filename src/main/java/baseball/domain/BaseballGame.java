package baseball.domain;

import java.util.Scanner;

public class BaseballGame {

    private final Pitcher pitcher;

    private final Batter batter;

    private final Count retryCount;

    private ScoreBoard scoreBoard;

    public BaseballGame(final Scanner scanner) {
        this.pitcher = new Pitcher(new FixedNumbersGenerator(scanner));
        this.batter = new Batter(new RandomNumbersGenerator());
        this.retryCount = new Count();
        this.scoreBoard = new ScoreBoard();
    }

    public void start() {
        boolean isEnd = false;
        while (!isEnd) {
            isEnd = pitcher.wantsToStop(new Scanner(System.in));
        }
    }
}
