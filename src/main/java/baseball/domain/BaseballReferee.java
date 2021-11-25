package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballReferee {
    private static final int ZERO_COUNT = 0;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 2;

    public BaseballState referee(List<Integer> baseballNumbers, List<Integer> inputNumbers) {
        int ballCount = calculateBall(baseballNumbers, inputNumbers);
        int strikeCount = calculateStrike(baseballNumbers, inputNumbers);
        return new BaseballState(ballCount - strikeCount, strikeCount);
    }

    private int calculateBall(List<Integer> baseballNumbers, List<Integer> inputNumbers) {
        int originalSize = baseballNumbers.size() + inputNumbers.size();
        Set<Integer> noneDuplicateNumbers = new HashSet<>();
        noneDuplicateNumbers.addAll(baseballNumbers);
        noneDuplicateNumbers.addAll(inputNumbers);
        return originalSize - noneDuplicateNumbers.size();
    }

    private int calculateStrike(List<Integer> baseballNumbers, List<Integer> inputNumbers) {
        int strikeCount = ZERO_COUNT;
        for (int i = START_INDEX; i <= END_INDEX; i++) {
            if (baseballNumbers.get(i).equals(inputNumbers.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }
}