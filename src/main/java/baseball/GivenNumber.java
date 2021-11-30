package baseball;

import static baseball.StringUtil.NUMBER_OF_DIGITS_OF_GAME_NUMBER;

import java.util.Set;

public class GivenNumber {
    private final Set<Integer> givenNumberSet;
    private final Integer[] givenNumberArray;

    public GivenNumber(Set<Integer> givenNumberSet) {
        this.givenNumberSet = givenNumberSet;
        givenNumberArray = givenNumberSet.toArray(new Integer[NUMBER_OF_DIGITS_OF_GAME_NUMBER]);
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
        return number == givenNumberArray[index];
    }

    private boolean isBall(Integer number) {
        return givenNumberSet.contains(number);
    }
}
