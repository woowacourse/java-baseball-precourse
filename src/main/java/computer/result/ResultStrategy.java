package computer.result;

import baseball.BaseBall;
import baseball.BaseBalls;

@FunctionalInterface
public interface ResultStrategy {
    boolean isSatisfy(BaseBalls answer, BaseBall compare);
}
