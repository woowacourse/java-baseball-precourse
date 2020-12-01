package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballNumbers {
    private List<Integer> baseballNumbers = new ArrayList<>();

    private BaseballNumbers(){}

    private BaseballNumbers(int[] baseballNumbers) {
        Arrays.stream(baseballNumbers).forEach(
                baseballNumber -> this.baseballNumbers.add(baseballNumber)
        );
    }

    public static BaseballNumbers getEmptyBaseballNumbers() {
        return new BaseballNumbers();
    }

    public static BaseballNumbers getBaseballNumberFromString(String baseballNumbers) {
        int[] intValueBaseballNumber = baseballNumbers
                .chars()
                .map(baseballNumber -> baseballNumber-'0')
                .toArray();

        BaseballNumbers newBaseballNumbers = new BaseballNumbers(intValueBaseballNumber);
        if(!BaseballNumbersValidator.isValid(newBaseballNumbers)) {
            throw new IllegalArgumentException();
        }

        return newBaseballNumbers;
    }

    public void add(int baseballNumber) {
        baseballNumbers.add(baseballNumber);
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers;
    }
}