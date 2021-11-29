package baseball.game;

import baseball.util.Assertion;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Baseball implements NumberMatcher<Baseball, BaseballCount> {

    private Integer[] baseballNumbers;

    public Baseball(Integer[] baseballNumbers) {
        Assertion.throwExceptionIfFalse(baseballNumbers.length == 3, "3자리의 숫자가 생성되지 않았습니다.");
        this.baseballNumbers = baseballNumbers;
    }

    public Baseball(String numbers) {
        Assertion.throwExceptionIfFalse(numbers.length() == 3, "3자리의 숫자를 입력해주세요.");
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
