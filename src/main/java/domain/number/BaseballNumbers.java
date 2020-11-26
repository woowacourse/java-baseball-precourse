package domain.number;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballNumbers {
    private static final int MAXIMUM_BASEBALL_NUMBER_COUNTS = 3;
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
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        while (!isGenerationComplete(baseballNumbers)) {
            generateRandomBaseballNumber(baseballNumbers);
        }
        return new BaseballNumbers(baseballNumbers);
    }

    private static boolean isGenerationComplete(List<BaseballNumber> baseballNumbers) {
        return baseballNumbers.size() == MAXIMUM_BASEBALL_NUMBER_COUNTS;
    }

    private static void generateRandomBaseballNumber(List<BaseballNumber> baseballNumbers) {
        int randomNumber = RandomUtils.nextInt(RANGE_MINIMUM, RANGE_MAXIMUM);
        BaseballNumber randomBaseballNumber = BaseballNumber.of(randomNumber);
        if (!randomBaseballNumber.isDuplicated(baseballNumbers)) {
            baseballNumbers.add(randomBaseballNumber);
        }
    }

    public static BaseballNumbers generateInputBaseballNumbers(List<Integer> inputBaseballNumbers) {
        List<BaseballNumber> baseballNumbers = inputBaseballNumbers.stream()
                .map(BaseballNumber::of)
                .collect(Collectors.toList());
        return new BaseballNumbers(baseballNumbers);
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
        return baseballNumber.equalTo(targetBaseballNumber);
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
                .filter(i -> this.baseballNumbers.get(i).equalTo(targetBaseballNumber))
                .count() == NECESSARY_COUNT_FOR_BALL_HINT;
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers.stream()
                .map(BaseballNumber::getBaseballNumber)
                .collect(Collectors.toList());
    }
}
