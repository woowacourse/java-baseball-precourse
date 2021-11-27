package logic;

import java.util.List;

public class BaseballGameJudge {
    private static final int NUMBER_COUNT = 3;
    private static final int INIT_COUNT = 0;

    private static Boolean isEnd;
    private static int ballCount;
    private static int strikeCount;

    public GameResultObject judgeGameResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        init();
        getCount(computerNumbers, userNumbers);
        judgeGameOver();

        return new GameResultObject(isEnd, ballCount, strikeCount);
    }

    public void init() {
        isEnd = false;
        ballCount = INIT_COUNT;
        strikeCount = INIT_COUNT;
    }

    private void getCount(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikeCount++;
            }
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
