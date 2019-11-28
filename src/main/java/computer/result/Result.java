package computer.result;

import baseball.BaseBall;
import baseball.BaseBalls;

import java.util.Arrays;

public enum Result {
    STRIKE(BaseBalls::isStrike),
    BALL(BaseBalls::isBall),
    NOTHING((answer, compare) -> true);

    private final ResultStrategy resultStrategy;

    Result(ResultStrategy resultStrategy) {
        this.resultStrategy = resultStrategy;
    }

    public static Result getResult(BaseBalls answer, BaseBall compare) {
        return Arrays.stream(values())
                .filter(result -> result.isSatisfy(answer, compare))
                .findFirst()
                .orElse(NOTHING);
    }

    private boolean isSatisfy(BaseBalls answer, BaseBall compare) {
        return this.resultStrategy.isSatisfy(answer, compare);
    }
}
