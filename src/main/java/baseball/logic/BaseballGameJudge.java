package baseball.logic;

import java.util.List;

public class BaseballGameJudge {
    private static final int NUMBER_COUNT = 3;
    private static final int INIT_COUNT = 0;

    private boolean isEnd;
    private int ballCount;
    private int strikeCount;

    public void init() {
        isEnd = false;
        ballCount = INIT_COUNT;
        strikeCount = INIT_COUNT;
    }

    public GameResultObject judgeGameResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        init();
        getStrikeCount(computerNumbers, userNumbers);
        getBallCount(computerNumbers, userNumbers);
        judgeGameOver();

        return new GameResultObject(isEnd, ballCount, strikeCount);
    }

    private void getStrikeCount(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikeCount++;
            }
        }
    }

    private void getBallCount(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (!computerNumbers.get(i).equals(userNumbers.get(i)) && computerNumbers.contains(userNumbers.get(i))) {
                ballCount++;
            }
        }
    }

    private void judgeGameOver() {
        if (strikeCount == NUMBER_COUNT) {
            isEnd = true;
        }
    }
}
