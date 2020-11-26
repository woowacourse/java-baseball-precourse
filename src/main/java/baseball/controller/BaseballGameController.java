package baseball.controller;

import baseball.domain.BaseballType;
import baseball.game.BaseballGameRule;
import baseball.game.BaseballResult;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BaseballGameController {
    private static final int RESTART_FLAG = 1;

    private final Viewer viewer;
    private final BaseballGameRule baseballGameRule;

    public BaseballGameController(final Scanner scanner) {
        this.viewer = new Viewer(scanner);
        this.baseballGameRule = new BaseballGameRule();
    }

    public void runBaseballGameApplication() {
        do {
            this.playBaseballOneGame();
        } while (this.viewer.inputRestartOrStopFlag() == RESTART_FLAG);
    }

    private void playBaseballOneGame() {
        boolean isAllStrike = false;
        List<Integer> randomBaseballList = viewer.createRandomBallNumberList();
        Set<Integer> randomBaseballSet = new HashSet<>(randomBaseballList);
        while (!isAllStrike) {
            List<Integer> playerBaseball = viewer.createBallsNumberList();
            BaseballResult baseballResult = this.baseballGameRule
                    .guessRandomAndPlayerBaseball(playerBaseball, randomBaseballList, randomBaseballSet);

            isAllStrike = baseballResult.isAllStrike();
            int ballCount = baseballResult.getBaseballTypeFrequency(BaseballType.BALL);
            int strikeCount = baseballResult.getBaseballTypeFrequency(BaseballType.STRIKE);
            this.viewer.printBaseballGameResult(baseballResult.isNothing(), ballCount, strikeCount);
        }
        this.viewer.printFinishGameMessage();
    }
}
