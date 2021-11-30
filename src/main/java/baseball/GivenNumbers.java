package baseball;

import static baseball.StringUtil.NUMBER_OF_DIGITS_OF_NUMBER;

import java.util.Set;

public class GivenNumbers {
    public final Set<Integer> givenNumbersSet;
    public final Integer[] givenNumbersArray;

    public GivenNumbers() {
        this.givenNumbersSet = RandomNumberFactory.generate();
        givenNumbersArray = givenNumbersSet.toArray(new Integer[NUMBER_OF_DIGITS_OF_NUMBER]);
    }

    public GameResult calculateGameResult(Integer[] inputNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < inputNumber.length; i++) {
            int number = inputNumber[i];
            if (isStrike(number, i)) {
                strike++;
                continue;
            }
            if (isBall(number)) {
                ball++;
            }
        }
        return new GameResult(strike, ball);
    }

    private boolean isStrike(int number, int index) {
        return number == givenNumbersArray[index];
    }

    private boolean isBall(Integer number) {
        return givenNumbersSet.contains(number);
    }
}
