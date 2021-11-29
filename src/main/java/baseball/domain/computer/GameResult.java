package baseball.domain.computer;

import static baseball.domain.number.BaseBallNumbers.BASEBALL_NUMBERS_LIMIT_SIZE;

import baseball.exception.computer.GameResultNegativeCountException;
import baseball.exception.computer.GameResultTotalCountException;
import java.util.Objects;

public class GameResult {

    private final int strikeCount;
    private final int ballCount;

    private GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static GameResult from(int strikeCount, int ballCount) {
        checkNegativeCount(strikeCount, ballCount);
        checkStrikeAndBallTotalCount(strikeCount, ballCount);
        return new GameResult(strikeCount, ballCount);
    }

    private static void checkStrikeAndBallTotalCount(int strikeCount, int ballCount) {
        if (Math.addExact(strikeCount, ballCount) > BASEBALL_NUMBERS_LIMIT_SIZE) {
            throw new GameResultTotalCountException();
        }
    }

    private static void checkNegativeCount(int strikeCount, int ballCount) {
        if (strikeCount < 0 || ballCount < 0) {
            throw new GameResultNegativeCountException();
        }
    }

    public boolean isFinished() {
        return strikeCount == BASEBALL_NUMBERS_LIMIT_SIZE;
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public int strikeCount() {
        return strikeCount;
    }

    public int ballCount() {
        return ballCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameResult that = (GameResult) o;
        return strikeCount == that.strikeCount && ballCount == that.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }
}

