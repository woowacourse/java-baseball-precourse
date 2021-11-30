package baseball.game;

import baseball.util.Assertion;
import java.util.Objects;

public class BaseballMatcher implements NumberMatcher<Baseball, BaseballCount> {
    public final Baseball targetBaseball;

    public BaseballMatcher(Baseball targetBaseball) {
        Assertion.throwExceptionIsNull(Objects.isNull(targetBaseball));
        this.targetBaseball = targetBaseball;
    }

    @Override
    public BaseballCount match(Baseball baseball) {
        return baseball.match(targetBaseball);
    }
}
