package baseball.domain;

import java.util.List;

@FunctionalInterface
public interface BaseballNumbersGenerator {
    List<BaseballNumber> generateBaseballNumbers();
}
