package baseball;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static baseball.StringUtil.*;

public class GivenNumbers {
    public final Set<Integer> givenNumbersSet;
    public final Integer[] givenNumbersArray;

    public GivenNumbers(Set<Integer> givenNumbersSet) {
        this.givenNumbersSet = givenNumbersSet;
        givenNumbersArray = givenNumbersSet.toArray(new Integer[NUMBER_OF_DIGITS_OF_NUMBER]);
    }

    public Map<String, Integer> operate(Integer[] inputNumber) {
        Integer strike = 0;
        Integer ball = 0;
        for (int i = 0; i < inputNumber.length; i++) {
            Integer number = inputNumber[i];
            if (number.equals(givenNumbersArray[i])) {
                strike++;
                continue;
            }
            if (givenNumbersSet.contains(number)) {
                ball++;
            }
        }
        HashMap<String, Integer> result = new HashMap<>();
        result.put(STRIKE, strike);
        result.put(BALL, ball);
        return result;
    }
}
