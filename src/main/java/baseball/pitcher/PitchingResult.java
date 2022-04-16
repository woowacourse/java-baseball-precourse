package baseball.pitcher;

import static baseball.hitter.HittingResult.BALL;
import static baseball.hitter.HittingResult.STRIKE;

import baseball.hitter.HittingResult;

public class PitchingResult {

    private static final int DEFAULT_PITCHING_COUNT = 3;

    private final int maxCount;
    private int totalCount = 0;
    private int strikeCount = 0;
    private int ballCount = 0;
    private boolean isPitchingEnd = false;
    private boolean isSuccess = false;

    PitchingResult() {
        maxCount = DEFAULT_PITCHING_COUNT;
    }

    public void add(HittingResult hittingResult) {
        assertHittingResult(hittingResult);
        assertPitchingCount();

        totalCount++;
        if (STRIKE.equals(hittingResult)) {
            strikeCount++;
        } else if (BALL.equals(hittingResult)) {
            ballCount++;
        }
        checkPitchingEnd();
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isPitchingEnd() {
        return isPitchingEnd;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isNothing() {
        return getBallCount() == 0 && getStrikeCount() == 0;
    }

    private void checkPitchingEnd() {
        if (totalCount == maxCount) {
            isPitchingEnd = true;
            checkSuccess();
        }
    }

    private void checkSuccess() {
        if (totalCount == strikeCount) {
            isSuccess = true;
        }
    }

    private void assertPitchingCount() {
        if (totalCount == maxCount) {
            throw new IllegalArgumentException(String.format(
                    "게임 결과는 최대 %d 번 만 실행할 수 있습니다", maxCount));
        }
    }

    private void assertHittingResult(HittingResult hittingResult) {
        if (hittingResult == null) {
            throw new IllegalArgumentException("HittingResult 가 null 입니다");
        }
    }
}
