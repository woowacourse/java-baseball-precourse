package baseball;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GivenNumbers {
    private final String SAME_POSITION_SAME_NUMBER = "STRIKE";
    private final String DIFFERENT_POSITION_SAME_NUMBER = "BALL";
    public final Set<Integer> givenNumbersSet;
    public final int[] givenNumbersArray;

    public GivenNumbers(Set<Integer> givenNumbersSet) {
        this.givenNumbersSet = givenNumbersSet;
        givenNumbersArray = toArray();
    }

    public Map<String, Integer> operate(int[] inputNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < inputNumber.length; i++) {
            int number = inputNumber[i];
            if (number == givenNumbersArray[i]) {
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

    private int[] toArray() {
        return givenNumbersSet.stream().mapToInt(Integer::intValue).toArray();
    }
}
