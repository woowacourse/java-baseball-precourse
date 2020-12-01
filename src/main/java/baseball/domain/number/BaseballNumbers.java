package baseball.domain.number;

import baseball.domain.exception.BaseballNumberCountsException;
import utils.RandomUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballNumbers {
    private static final int NECESSARY_BASEBALL_NUMBER_COUNTS = 3;
    private static final int FIRST_BALL_INDEX = 0;
    private static final int LAST_BALL_INDEX = 2;

    private final List<BaseballNumber> baseballNumbers;

    private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumbers generateRandomBaseballNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (!isGenerationComplete(randomNumbers)) {
            int randomNumber = RandomUtils.nextInt(BaseballNumber.RANGE_MINIMUM, BaseballNumber.RANGE_MAXIMUM);
            randomNumbers.add(randomNumber);
        }
        List<BaseballNumber> baseballNumbers = randomNumbers.stream()
                .map(BaseballNumber::valueOf)
                .collect(Collectors.toList());
        return new BaseballNumbers(baseballNumbers);
    }

    private static boolean isGenerationComplete(Set<Integer> randomNumbers) {
        return randomNumbers.size() == NECESSARY_BASEBALL_NUMBER_COUNTS;
    }

    public static BaseballNumbers generateInputBaseballNumbers(List<Integer> inputBaseballNumbers) {
        validateDuplication(inputBaseballNumbers);
        List<BaseballNumber> baseballNumbers = inputBaseballNumbers.stream()
                .map(BaseballNumber::valueOf)
                .collect(Collectors.toList());
        return new BaseballNumbers(baseballNumbers);
    }

    private static void validateDuplication(List<Integer> inputBaseballNumbers) {
        int distinctCounts = (int) inputBaseballNumbers.stream()
                .distinct()
                .count();
        if (distinctCounts != NECESSARY_BASEBALL_NUMBER_COUNTS) {
            throw new BaseballNumberCountsException(distinctCounts);
        }
    }

    public int calculateStrikeCounts(BaseballNumbers targetBaseballNumbers) {
        return (int) IntStream.rangeClosed(FIRST_BALL_INDEX, LAST_BALL_INDEX)
                .filter(index -> isStrike(index, targetBaseballNumbers))
                .count();
    }

    private boolean isStrike(int index, BaseballNumbers targetBaseballNumbers) {
        BaseballNumber baseballNumber = this.baseballNumbers.get(index);
        BaseballNumber targetBaseballNumber = targetBaseballNumbers.baseballNumbers
                .get(index);
        return baseballNumber.equals(targetBaseballNumber);
    }

    public int calculateBallCounts(BaseballNumbers targetBaseballNumbers) {
        return (int) IntStream.rangeClosed(FIRST_BALL_INDEX, LAST_BALL_INDEX)
                .filter(index -> isBall(index, targetBaseballNumbers))
                .count();
    }

    private boolean isBall(int index, BaseballNumbers targetBaseballNumbers) {
        BaseballNumber baseballNumber = this.baseballNumbers.get(index);
        BaseballNumber targetBaseballNumber = targetBaseballNumbers.baseballNumbers
                .get(index);
        return !baseballNumber.equals(targetBaseballNumber) && this.baseballNumbers.contains(targetBaseballNumber);
    }
}
