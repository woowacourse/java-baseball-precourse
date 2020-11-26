package domain.number;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballNumbers {

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
        return baseballNumbers.size() == 3;
    }

    private static void generateRandomBaseballNumber(List<BaseballNumber> baseballNumbers) {
        int randomNumber = RandomUtils.nextInt(1, 9);
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
        return (int) IntStream.rangeClosed(0, 2)
                .filter(index -> isStrike(index, targetBaseballNumbers))
                .count();
    }

    private boolean isStrike(int index, BaseballNumbers targetBaseballNumbers) {
        BaseballNumber baseballNumber = this.baseballNumbers.get(index);
        BaseballNumber targetBaseballNumber = targetBaseballNumbers.baseballNumbers
                .get(index);
        return baseballNumber.equalTo(targetBaseballNumber);
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers.stream()
                .map(BaseballNumber::getBaseballNumber)
                .collect(Collectors.toList());
    }
}
