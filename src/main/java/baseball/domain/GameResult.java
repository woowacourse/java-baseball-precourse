package baseball.domain;

public class GameResult {
    private long strikeCount;
    private long ballCount;

    public void checkResult(BaseballNums answerBaseballNums, BaseballNums playerBaseballNums) {
        this.strikeCount = counterStrike(answerBaseballNums, playerBaseballNums);
        this.ballCount = counterBall(answerBaseballNums, playerBaseballNums);
    }

    private long counterStrike(BaseballNums answerBaseballNums, BaseballNums playerBaseballNums) {
        return answerBaseballNums.getBaseballNums().stream()
                .filter(idx -> playerBaseballNums.getBaseballNums().contains(idx))
                .filter(idx -> isValidateSameIndex(idx, answerBaseballNums, playerBaseballNums))
                .count();
    }

    private boolean isValidateSameIndex(int idx, BaseballNums answerBaseballNums, BaseballNums playerBaseballNums) {
        return answerBaseballNums.getBaseballNums().indexOf(idx) == playerBaseballNums.getBaseballNums().indexOf(idx);
    }

    public long counterBall(BaseballNums answerBaseballNums, BaseballNums playerBaseballNums) {
        return answerBaseballNums.getBaseballNums().stream()
                .filter(idx -> playerBaseballNums.getBaseballNums().contains(idx))
                .filter(idx -> isValidateDifferentIdx(idx, answerBaseballNums, playerBaseballNums))
                .count();
    }

    private boolean isValidateDifferentIdx(int idx, BaseballNums answerBaseballNums, BaseballNums playerBaseballNums) {
        return answerBaseballNums.getBaseballNums().indexOf(idx) != playerBaseballNums.getBaseballNums().indexOf(idx);
    }
}
