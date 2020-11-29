package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        return new BaseballNumbers(intValueBaseballNumber);
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers;
    }
}