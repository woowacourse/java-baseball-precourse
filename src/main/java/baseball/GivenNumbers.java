package baseball;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GivenNumbers {
    private static final String SAME_POSITION_SAME_NUMBER = "STRIKE";
    private static final String DIFFERENT_POSITION_SAME_NUMBER = "BALL";
    private static final int NUMBER_OF_DIGITS = 3;
    public final Set<Integer> givenNumbersSet;
    public final Integer[] givenNumbersArray;

    public GivenNumbers(Set<Integer> givenNumbersSet) {
        this.givenNumbersSet = givenNumbersSet;
        givenNumbersArray = givenNumbersSet.toArray(new Integer[NUMBER_OF_DIGITS]);
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
        result.put(SAME_POSITION_SAME_NUMBER, strike);
        result.put(DIFFERENT_POSITION_SAME_NUMBER, ball);
        return result;
    }
}
