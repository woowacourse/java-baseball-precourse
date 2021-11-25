package baseball.domain;

import java.util.Objects;

public class Result {

    private final int strikeCount;
    private final int ballCount;

    public Result(int strikeCount, int ballCount) {
        validatePositive(strikeCount);
        validatePositive(ballCount);
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    private void validatePositive(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be negative");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result result = (Result) o;
        return strikeCount == result.strikeCount && ballCount == result.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }

    @Override
    public String toString() {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }

        if (ballCount == 0) {
            return strikeCount + "스트라이크";
        }

        if (strikeCount == 0) {
            return ballCount + "볼";
        }

        return ballCount + "볼 " + strikeCount + "스트라이크";
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
