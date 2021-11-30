package baseball;

import static baseball.StringUtil.BALL;
import static baseball.StringUtil.NUMBER_OF_DIGITS_OF_NUMBER;
import static baseball.StringUtil.STRIKE;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GivenNumbers {
    public final Set<Integer> givenNumbersSet;
    public final Integer[] givenNumbersArray;

    public GivenNumbers() {
        this.givenNumbersSet = RandomNumberFactory.generate();
        givenNumbersArray = givenNumbersSet.toArray(new Integer[NUMBER_OF_DIGITS_OF_NUMBER]);
    }

    public Map<String, Integer> operate(Integer[] inputNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < inputNumber.length; i++) {
            int number = inputNumber[i];
            if(isStrike(number, i)) {
                strike++;
                continue;
            }
            if(isBall(number)) {
                ball++;
            }
        }
        HashMap<String, Integer> result = new HashMap<>();
        result.put(STRIKE, strike);
        result.put(BALL, ball);
        return result;
    }

    private boolean isStrike(int number, int index) {
        return number == givenNumbersArray[index];
    }

    private boolean isBall(Integer number) {
        return givenNumbersSet.contains(number);
    }
}
