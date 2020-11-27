package baseball.controller;

import baseball.domain.BaseballType;
import baseball.domain.ExecutionFlagType;
import baseball.domain.SingletonFlagMap;
import baseball.game.BaseballGameRule;
import baseball.game.BaseballResult;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BaseballGameController {
    private final Viewer viewer;
    private final BaseballGameRule baseballGameRule;

    public BaseballGameController(final Scanner scanner) {
        this.viewer = new Viewer(scanner);
        this.baseballGameRule = new BaseballGameRule();
    }

    public void runBaseballGameApplication() {
        do {
            this.playBaseballOneGame();
        } while (this.isRestart());
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

    private boolean isRestart() {
        while (true) {
            try {
                int inputFlag = this.viewer.inputRestartOrStopFlag();
                ExecutionFlagType resultOfExecutionFlag = SingletonFlagMap.getInstance().getFlagFromNumber(inputFlag);
                return resultOfExecutionFlag == ExecutionFlagType.RESTART;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("[Error] : 1과 2외의 다른 입력을 하였습니다.");
            }
        }
    }
}
