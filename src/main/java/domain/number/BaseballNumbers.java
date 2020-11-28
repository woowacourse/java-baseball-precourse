package domain.number;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballNumbers {
    private static final int NECESSARY_BASEBALL_NUMBER_COUNTS = 3;
    private static final int RANGE_MINIMUM = 1;
    private static final int RANGE_MAXIMUM = 9;
    private static final int FIRST_BALL_INDEX = 0;
    private static final int LAST_BALL_INDEX = 2;
    private static final int NECESSARY_COUNT_FOR_BALL_HINT = 1;

    private final List<BaseballNumber> baseballNumbers;

    private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumbers generateRandomBaseballNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (!isGenerationComplete(randomNumbers)) {
            int randomNumber = RandomUtils.nextInt(RANGE_MINIMUM, RANGE_MAXIMUM);
            randomNumbers.add(randomNumber);
        }
        List<BaseballNumber> baseballNumbers = randomNumbers.stream()
                .map(BaseballNumber::of)
                .collect(Collectors.toList());
        return new BaseballNumbers(baseballNumbers);
    }

    private static boolean isGenerationComplete(Set<Integer> baseballNumbers) {
        return baseballNumbers.size() == NECESSARY_BASEBALL_NUMBER_COUNTS;
    }

    public static BaseballNumbers generateInputBaseballNumbers(List<Integer> inputBaseballNumbers) {
        validateDuplication(inputBaseballNumbers);
        List<BaseballNumber> baseballNumbers = inputBaseballNumbers.stream()
                .map(BaseballNumber::of)
                .collect(Collectors.toList());
        return new BaseballNumbers(baseballNumbers);
    }

    private static void validateDuplication(List<Integer> inputBaseballNumbers) {
        int distinctCounts = (int) inputBaseballNumbers.stream()
                .distinct()
                .count();
        if (distinctCounts != NECESSARY_BASEBALL_NUMBER_COUNTS) {
            throw new IllegalArgumentException();
        }
    }

    public int calculateStrikeCounts(BaseballNumbers targetBaseballNumbers) {
        return (int) IntStream.rangeClosed(FIRST_BALL_INDEX, LAST_BALL_INDEX)
                .filter(i -> isStrike(i, targetBaseballNumbers))
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
                .filter(i -> isBall(i, targetBaseballNumbers))
                .count();
    }

    private boolean isBall(int index, BaseballNumbers targetBaseballNumbers) {
        BaseballNumber targetBaseballNumber = targetBaseballNumbers.baseballNumbers
                .get(index);
        return IntStream.rangeClosed(FIRST_BALL_INDEX, LAST_BALL_INDEX)
                .filter(i -> i != index)
                .filter(i -> this.baseballNumbers.get(i).equals(targetBaseballNumber))
                .count() == NECESSARY_COUNT_FOR_BALL_HINT;
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers.stream()
                .map(BaseballNumber::getBaseballNumber)
                .collect(Collectors.toList());
    }
}
