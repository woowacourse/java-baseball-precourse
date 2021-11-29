package baseball.game;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Baseball implements NumberMatcher<Baseball, BaseballCount> {

    private Integer[] baseballNumbers;

    public Baseball(Integer[] baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public Baseball(String numbers) {
        this.baseballNumbers = convertStringToArray(numbers);
    }

    private Integer[] convertStringToArray(String numbers) {
        return numbers.chars()
            .map(Character::getNumericValue)
            .boxed()
            .toArray(Integer[]::new);
    }

    @Override
    public BaseballCount match(Baseball target) {
        int strike = countStrike(target);
        int ball = countBall(target);
        return new BaseballCount(BaseballCount.Strike.of(strike), BaseballCount.Ball.of(ball - strike));
    }

    private int countStrike(Baseball target) {
        return (int)IntStream
            .range(0, this.baseballNumbers.length)
            .filter(index -> isEqualsIndexOfNumber(target, index))
            .count();
    }

    private boolean isEqualsIndexOfNumber(Baseball baseballNumber, int index) {
        return baseballNumber.baseballNumbers[index].equals(baseballNumbers[index]);
    }

    private int countBall(Baseball target) {
        return Arrays.stream(baseballNumbers)
            .mapToInt(baseballNumber -> (int)Arrays.stream(target.baseballNumbers)
                .filter(baseballNumber::equals)
                .count())
            .sum();
    }

}
